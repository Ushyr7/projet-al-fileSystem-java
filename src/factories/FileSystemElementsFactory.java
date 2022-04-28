package factories;

import FileSystem.File;
import FileSystem.Repository;
import FileSystem.SymLink;


public interface FileSystemElementsFactory {
	
	/**
	 * 
	 * @param name
	 * @return a file with given name
	 */
	public File createFile(String name);
	
	/**
	 * 
	 * @param name
	 * @return a repository with given name
	 */
	public Repository createRepository(String name);
	
	/**
	 * 
	 * @param name
	 * @param path
	 * @return a symbolic link with given name and path
	 */
	public SymLink createSymLink(String name, String path);
}
