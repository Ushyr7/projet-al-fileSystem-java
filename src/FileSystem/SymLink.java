package FileSystem;

/**
 * Interface representing a symbolic link
 * 
 * @author Quentin RIDEL
 *
 */
public interface SymLink extends FileSystemElements {
	
	/**
	 * 
	 * @return the path that this symbolic links points to
	 */
	public String getPath();
	
	/**
	 * 
	 * @param path
	 */
	public void setPath(String path);
	
}
