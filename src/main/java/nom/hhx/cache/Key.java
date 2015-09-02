package nom.hhx.cache;

/**
 * All the key of the cache object must implements the {@link Key} and the {@code hashcode()} method
 * 
 * @author huanghx( huanghx@act.buaa.edu.cn )
 */
public interface Key
{
    public long uniqecode();
    
    public void setcode( long code );
}
