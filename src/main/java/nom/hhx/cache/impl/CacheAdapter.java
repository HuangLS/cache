package nom.hhx.cache.impl;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import nom.hhx.cache.Cache;
import nom.hhx.cache.Key;
import nom.hhx.cache.impl.exception.NoUnusedObjectExeption;

public abstract class CacheAdapter<KEY extends Key, OBJECT> implements Cache<KEY, OBJECT>
{
    private final int cachesize;
    
    protected AtomicInteger hitcount = new AtomicInteger(0);
    protected AtomicInteger misscount = new AtomicInteger(0);
    
    public CacheAdapter( int cachesize )
    {
        this.cachesize = cachesize;
    }
    
    public int getHitCount()
    {
        return hitcount.get();
    }
    
    public int getMissCount()
    {
        return misscount.get();
    }
    
    protected void hitCountPlus()
    {
        hitcount.incrementAndGet();
    }
    
    protected void missCountPlus()
    {
        misscount.incrementAndGet();
    }
    
    public boolean put( KEY key, OBJECT object )
    {
        int size = size();
        if( size < cachesize )
            realput( key, object );
        else
        {
            try
            {
                swrap();
            }
            catch( NoUnusedObjectExeption e )
            {
                return false;
            }
            realput( key, object );
        }
        return true;
    }
    
    public boolean putAll( Map<KEY,OBJECT> list)
    {
        int size = list.size() + size();
        if( size < cachesize )
        {
            for( KEY key : list.keySet() )
            {
                OBJECT object = list.get( key );
                realput( key, object );
            }
        }
        else
        {
            try
            {
                swrap();
            }
            catch( NoUnusedObjectExeption e )
            {
                return false;
            }
            int size2 = list.size() + size();
            if( size2 < cachesize )
            {
                for( KEY key : list.keySet() )
                {
                    OBJECT object = list.get( key );
                    realput( key, object );
                }
            }
        }
        return true;    
    }
    
    abstract void realput( KEY key, OBJECT object);
}
