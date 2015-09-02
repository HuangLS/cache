package nom.hhx.cache.factory;

import java.util.Collection;
import java.util.Properties;

import nom.hhx.cache.Cache;
import nom.hhx.cache.Key;
import nom.hhx.cache.impl.LRUCache;
import nom.hhx.cache.impl.MostUseCache;
import nom.hhx.cache.impl.SoftCache;
import nom.hhx.cache.impl.WeakCache;

public class CacheFactory
{
    public CacheFactory()
    {
        this.builder = new CacheBuilder();
    }
    
    private CacheBuilder builder; 
    
    public CacheBuilder getBuilder()
    {
        return this.builder;
    }
    
    public <KEY extends Key,OBJECT> Cache<?,?> newCache( Class clasz,KEY keyclass, OBJECT objectclass )
    {
        Properties properties = builder.getProperties();
        long cachesize = cachesizeFromPercent( Integer.valueOf( properties.getProperty( "jvmheap_percent" ) ) );
        if( clasz.equals( LRUCache.class ) )
            return new LRUCache<KEY,OBJECT>( cachesize );
        if( clasz.equals( MostUseCache.class ) )
            return new MostUseCache<KEY,OBJECT>( cachesize );
        if( clasz.equals( SoftCache.class ) )
            return new SoftCache<KEY,OBJECT>( cachesize );
        else
            return new WeakCache<KEY,OBJECT>( cachesize );
    }

    private long cachesizeFromPercent( Integer percent )
    {
        long totalsize = Runtime.getRuntime().maxMemory();
        return (long) (totalsize*percent*0.01);
    }
}
