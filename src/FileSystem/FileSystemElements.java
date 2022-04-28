package FileSystem;

/**
 * Interface representing an Element of a FileSystem.
 * 
 * @author Quentin RIDEL
 *
 */
public interface FileSystemElements {
	

	/**
	 * 
	 * @return name of the element.
	 */
	public String getName();
		
	
	/**
	 * 
	 * @return size in bytes 
	 */
	public int getSize();
	
}
