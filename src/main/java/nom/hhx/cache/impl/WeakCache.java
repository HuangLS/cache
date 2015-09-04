package nom.hhx.cache.impl;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

import nom.hhx.cache.Key;

public class WeakCache<KEY extends Key, OBJECT> extends RefferencedCacheAdapter<KEY, OBJECT>
{
    
    private static class Entry<KEY extends Key,OBJECT> extends WeakReference<OBJECT> implements KeyEntry<KEY,OBJECT>
    {
        private KEY key;
        private Entry(KEY key, OBJECT referent, ReferenceQueue< ? super OBJECT> pollqueue )
        {
            super( referent, pollqueue );
            this.key = key;
        }

        @Override
        public KEY getkey()
        {
            return key;
        }
        
    }
    

    public WeakCache( int cachesize )
    {
        super( cachesize );
    }

    @Override
    void realput( KEY key, OBJECT object )
    {
        Entry<KEY,OBJECT> entry = new Entry<KEY,OBJECT>( key, object, (ReferenceQueue)this.pollqueue );
        this.cache.put( key, entry );
    }
    
}
