package nom.hhx.cache.impl;

import java.util.Map;

import nom.hhx.cache.Key;
import nom.hhx.cache.Statistics;

public class MostUseCache<KEY extends Key, OBJECT> extends CacheAdapter
{
    public MostUseCache( long cachesize )
    {
        super( cachesize );
    }

    public void put( Key key, Object object )
    {
        // TODO Auto-generated method stub
        
    }

    public void putAll( Map list )
    {
        // TODO Auto-generated method stub
        
    }

    public Object get( Key key )
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

    public boolean contains( Key key )
    {
        // TODO Auto-generated method stub
        return false;
    }

    public void wrap()
    {
        // TODO Auto-generated method stub
        
    }
}
