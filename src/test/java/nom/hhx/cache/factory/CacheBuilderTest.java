package nom.hhx.cache.factory;

import nom.hhx.cache.factory.CacheBuilder.Settings;

import org.junit.Before;
import org.junit.Test;

public class CacheBuilderTest
{
    private CacheBuilder builder;
    @Before
    public void setUp()
    {
        builder = new CacheBuilder();
    }
    
    @Test
    public void TestJvmPencentValueFormatCheck()
    {
        this.builder.setProperty( Settings.JVM_PERCENT_SETNAME, "100" );
        this.builder.setProperty( Settings.JVM_PERCENT_SETNAME, "%20" );
    }
}
