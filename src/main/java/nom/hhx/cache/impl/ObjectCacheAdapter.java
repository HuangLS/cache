package nom.hhx.cache.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import nom.hhx.cache.Key;

public abstract class ObjectCacheAdapter<KEY extends Key, OBJECT> extends CacheAdapter<KEY,OBJECT>

{
    public ObjectCacheAdapter( int cachesize )
    {
        super( cachesize );
        cache = new ConcurrentHashMap<KEY,OBJECT>( (int)(cachesize/0.75) );
    }
    
    protected Map<KEY,OBJECT> cache;
}
