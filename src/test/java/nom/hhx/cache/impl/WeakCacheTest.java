package nom.hhx.cache.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import nom.hhx.cache.Cache;
import nom.hhx.cache.factory.CacheFactory;
import nom.hhx.cache.impl.exception.NoUnusedObjectExeption;
import nom.hhx.cache.key.LongKey;

public class WeakCacheTest
{
    private Cache<LongKey,String> cache;
    private LongKey[] keys;
    private String[] values;
    private final int keynum = 10;
    @Before
    public void setup()
    {
        cache = new CacheFactory().newCache( WeakCache.class );
        keys = new LongKey[keynum];
        values = new String[keynum];
        for( int i = 0; i<keys.length; i++ )
        {
            keys[i] = new LongKey();
            values[i] = keys[i].toString();
            cache.put( keys[i], values[i] );
        }
    }
    
    @Test
    public void RefferencQueueTest()
    {
        Assert.assertEquals( keynum, cache.size() );
        values[0] = null;
        System.gc();
        try
        {
            Thread.sleep( 100 );
            cache.swrap();
        }
        catch ( NoUnusedObjectExeption | InterruptedException e )
        {
            Assert.assertNull( e );
        }
        Assert.assertEquals( 9, cache.size() );
        values[1] = null;
        System.gc();
        try
        {
            Thread.sleep( 100 );
            cache.swrap();
        }
        catch ( NoUnusedObjectExeption | InterruptedException e )
        {
            Assert.assertNull( e );
        }
        Assert.assertEquals( 8, cache.size() );
    }
}
