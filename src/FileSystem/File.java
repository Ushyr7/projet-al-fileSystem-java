package FileSystem;


/**
 * Interface representing a File 
 * 
 * @author Quentin RIDEL
 *
 */
public interface File extends FileSystemElements {
	
	/**
	 * maximum size for a file
	 */
	static final int MAX_BYTES_NUMBER = 10000;
	
	/**
	 * 
	 * @return content of the file
	 */
	public byte[] getContent();
	
	
	/**
	 * 
	 * @param content
	 */
	public void setContent(byte[] content);
}
