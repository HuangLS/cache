package nom.hhx.cache.impl;

import java.util.Map;

import nom.hhx.cache.Key;
import nom.hhx.cache.Statistics;

public class LRUCache<KEY extends Key, OBJECT> extends CacheAdapter<KEY, OBJECT>
{
    public LRUCache( long cachesize )
    {
        super( cachesize );
    }

    public void put( KEY key, OBJECT object )
    {
        // TODO Auto-generated method stub
        
    }

    public void putAll( Map<KEY,OBJECT> list )
    {
        // TODO Auto-generated method stub
        
    }

    public OBJECT get( KEY key )
    {
        // TODO Auto-generated method stub
        return null;
    }

    public Statistics getStatistics()
    {
        // TODO Auto-generated method stub
        return null;
    }

    public int size()
    {
        // TODO Auto-generated method stub
        return 0;
    }

    public void clear()
    {
        // TODO Auto-generated method stub
        
    }

    public boolean contains( KEY key )
    {
        // TODO Auto-generated method stub
        return false;
    }

    public void wrap()
    {
        // TODO Auto-generated method stub
        
    }
}
