package nom.hhx.cache.factory;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CacheBuilder
{
    
    private Properties properties;
    private final Logger logger = LoggerFactory.getLogger( CacheBuilder.class );
    
    public static class Settings
    {
        public static final String JVM_PERCENT_SETNAME = "jvmheap_percent";
        public static final String AUTO_KEY_SETNAME = "autokey";
    }
    
    public CacheBuilder()
    {
        this.properties = new Properties();
        this.properties.setProperty( Settings.JVM_PERCENT_SETNAME, "20" );
        this.properties.setProperty( Settings.AUTO_KEY_SETNAME, "true" );
    }
        
    public CacheBuilder setProperty( String name, String value )
    {
        if( name == Settings.JVM_PERCENT_SETNAME )
        {
            try
            {
                int val = Integer.valueOf( value );
                if( val >= 100 )
                    throw new Exception();
            }
            catch( Exception e )
            {
                logger.warn( "Wrong settings value for " + Settings.JVM_PERCENT_SETNAME + ". Default value will count." );
            }
        }
        this.properties.setProperty( name, value );
        return this;
    }
    
    protected Properties getProperties()
    {
        return this.properties;
    }
}
