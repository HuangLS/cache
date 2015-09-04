package nom.hhx.cache.factory;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import nom.hhx.cache.Cache;
import nom.hhx.cache.Key;
import nom.hhx.cache.impl.SoftCache;
import nom.hhx.cache.impl.WeakCache;

public class CacheFactory
{
    public CacheFactory()
    {
        this.builder = new CacheBuilder();
    }
    
    
    private Logger logger = LoggerFactory.getLogger( CacheFactory.class );
    private CacheBuilder builder; 
    
    public CacheBuilder getBuilder()
    {
        return this.builder;
    }
    
    public <KEY extends Key,OBJECT> Cache<KEY,OBJECT> newCache( Class clasz )
    {
        Properties properties = builder.getProperties();
        int cachesize = Integer.valueOf( properties.getProperty( CacheBuilder.Settings.JVM_PERCENT_SETNAME ) ) ;
        if( clasz.equals( WeakCache.class ) )
        {
            logger.debug( "Cache " + clasz.toString() + "created." );
            return new WeakCache<KEY,OBJECT>( cachesize );
        }
        if( clasz.equals( SoftCache.class ))
        {
            logger.debug( "Cache " + clasz.toString() + "created." );
            return new SoftCache<KEY,OBJECT>( cachesize );
        }
        return null;
    }
}
