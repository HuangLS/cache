package nom.hhx.cache;

import java.util.Map;


/**
 * The {@link Cache} interface defines the basic functions of a cache.
 * The cache is accessed by KEY, that is all the cached object must has a unique KEY.
 * 
 * @param <KEY> 
 * @param <VALUE>
 * 
 * @author huanghx( huanghx@act.buaa.edu.cn )
 */
public interface Cache < KEY extends Key, OBJECT >
{
    
    /**
     * put the object to the cache
     * 
     * @param key
     * @param object
     */
    public void put( KEY key, OBJECT object );
    
    /**
     * @param list
     */
    public void putAll( Map< KEY, OBJECT > list );
    
    /**
     * @param key
     * @return
     */
    public OBJECT get( KEY key );
    
    
    /**
     * @return the Statistics of the cache
     */
    public Statistics getStatistics();
    
    /**
     * @return
     */
    public int size();
    
    /**
     * 
     */
    public void clear();
    
    /**
     * @param key
     * @return
     */
    public boolean contains( KEY key );
    
    /**
     * 
     */
    public void wrap();
}
