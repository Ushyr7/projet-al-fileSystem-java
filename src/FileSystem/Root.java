package FileSystem;

/**
 * Interface representing a root repository
 * 
 * @author Quentin RIDEL
 *
 */
public interface Root extends Repository {
	
	/**
	 * 
	 * @param element an element in the fileSystem
	 * @return the path to this element if it exists, null if it doesn't
	 */
	public String getElementPath(FileSystemElements element);
	
	/**
	 * 
	 * @param path
	 * @param f
	 */
	public void addToFiles(String path, File f);
	
	/**
	 * 
	 * @param path
	 * @param r
	 */
	public void addToRepositories(String path, Repository r);
	
	/**
	 * 
	 * @param path
	 * @param sl
	 */
	public void addToSymbolicLinks(String path, SymLink sl);

}
