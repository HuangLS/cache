package nom.hhx.cache.impl;

import nom.hhx.cache.Cache;
import nom.hhx.cache.Key;

public abstract class CacheAdapter<KEY extends Key, OBJECT> implements Cache
{
    private long cachesize;
    public CacheAdapter( long cachesize2 )
    {
        this.cachesize = cachesize2;
    }
}
