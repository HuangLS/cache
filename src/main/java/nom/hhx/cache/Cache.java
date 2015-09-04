package nom.hhx.cache;

import java.util.Map;

import nom.hhx.cache.impl.exception.NoUnusedObjectExeption;


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
     * @return true if sccuss put in the cache
     */
    public boolean put( KEY key, OBJECT object );
    
    /**
     * @param list
     */
    public boolean putAll( Map< KEY, OBJECT > list );
    
    /**
     * @param key
     * @return
     */
    public OBJECT get( KEY key );
    
    
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
     * Clean the unused object.
     */
    public void swrap() throws NoUnusedObjectExeption;
    
    /**
     * @return
     */
    public int getHitCount();
    
    /**
     * @return
     */
    public int getMissCount();
    
}
