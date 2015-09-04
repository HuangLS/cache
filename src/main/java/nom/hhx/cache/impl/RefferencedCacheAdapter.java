package nom.hhx.cache.impl;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import nom.hhx.cache.Key;
import nom.hhx.cache.impl.exception.NoUnusedObjectExeption;

public abstract class RefferencedCacheAdapter<KEY extends Key, OBJECT > extends CacheAdapter<KEY,OBJECT>
{
    
    static interface KeyEntry<KEY,OBJECT>
    {
        public KEY getkey();
    }
    
    public RefferencedCacheAdapter( int cachesize )
    {
        super( cachesize );
        this.cache = new ConcurrentHashMap<KEY,Reference<OBJECT>>( (int)(cachesize/0.75));
    }
    
    protected Map<KEY,Reference<OBJECT>> cache;
    protected ReferenceQueue<KeyEntry<KEY,OBJECT>> pollqueue = new ReferenceQueue<KeyEntry<KEY,OBJECT>>();
    
   public void swrap() throws NoUnusedObjectExeption
   {
       KeyEntry<KEY,OBJECT> object;
       int len = 0;
       while( ( object = (KeyEntry<KEY,OBJECT>) this.pollqueue.poll() ) != null )
       {
           len++;
           KEY key = object.getkey();
           cache.remove( key );
       }
       if( len == 0 )
       {
           throw new NoUnusedObjectExeption();
       }
   }
   
   public int size()
   {
       return cache.size();
   }
   
   public void clear()
   {
       this.cache.clear();
       this.misscount.set( 0 );
       this.hitcount.set( 0 );
       try
       {
           swrap();
       }
       catch ( NoUnusedObjectExeption e )
       {
           //do nothing
       }
   }
   
   @Override
   public OBJECT get( KEY key )
   {
       Reference<OBJECT> toret = this.cache.get( key );
       OBJECT ret = toret.get();
       if( ret == null )
       {
           this.misscount.incrementAndGet();
       }
       else
           this.hitcount.incrementAndGet();
       return ret;
   }
   
   public boolean contains( KEY key )
   {
       return this.cache.containsKey( key );
   }
}
