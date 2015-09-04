package nom.hhx.cache.impl;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

import nom.hhx.cache.Key;

public class SoftCache<KEY extends Key, OBJECT> extends RefferencedCacheAdapter<KEY,OBJECT>
{

    private static class Entry<KEY , OBJECT > extends SoftReference<OBJECT> implements KeyEntry<KEY,OBJECT>
    {
        
        private KEY key;

        private Entry( KEY key,OBJECT referent, ReferenceQueue<? super OBJECT> q )
        {
            super( referent, q );
            this.key = key;
        }

        @Override
        public KEY getkey()
        {
            return key;
        }
        
    }
    
    
    public SoftCache( int cachesize )
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
