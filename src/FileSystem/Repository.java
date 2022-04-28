package FileSystem;

import java.util.List;

/**
 * Interface representing a Repository
 * 
 * @author Quentin RIDEL
 *
 */
public interface Repository extends FileSystemElements {
	
	/**
	 * 
	 * @return list of all elements in this repository
	 */
	public List<FileSystemElements> getContent();
	
	/**
	 * 
	 * @param f a file
	 */
	public void addFile(File f);
	
	/**
	 * 
	 * @param sl a symbolic link
	 */
	public void addSymLink(SymLink sl);
	
	/**
	 * 
	 * @param a repository
	 */
	public void addRepository(Repository r);
}
