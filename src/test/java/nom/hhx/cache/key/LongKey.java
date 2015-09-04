package nom.hhx.cache.key;

import java.util.concurrent.atomic.AtomicLong;

import nom.hhx.cache.Key;

public class LongKey implements Key
{
    private static final AtomicLong pool = new AtomicLong(0);

    private long key;
    
    public LongKey()
    {
        this.key = pool.incrementAndGet();
    }
    
    public long uniqecode()
    {
        return this.key;
    }

    public void setcode( long code )
    {
        
    }
    
    public String toString()
    {
        return String.valueOf( key );
    }
}
