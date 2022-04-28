package fileSystemController;

import FileSystem.File;
import FileSystem.Repository;
import FileSystem.Root;
import FileSystem.SymLink;

public interface IController {

	/**
	 * Returns the only instance of root.
	 */
	public Root getRoot();
	
	 /**
     * Creates a File.
     *
     * @param name the name of the File
     */
	public File createFile(String name);
	
	/**
     * Creates a Repository.
     *
     * @param name the name of the Repository
     */
	public Repository createRepository(String name);
	
	/**
     * Creates a Symbolic Link
     *
     * @param name the name of the Symbolic link
     * @param path the path this link points to
     */
	public SymLink createSymbolicLink(String name, String path);
	
	/**
     * add a File in the content of a Repository
     * 
     * @param r the Repository that will contain the file
     * @param f the file that will be added to the repository
     */
	public void addFileToRepository(Repository r, File f);
	

	/**
     * add a Repository in the content of a Repository
     * 
     * @param container the container Repository
     * @param r the Repository that will be added to container's content
     */
	public void addRepositoryToRepository(Repository container, Repository r);
	
	
	/**
     * add a Symbolic link to the content of a Repository
     * 
     * @param r the container Repository
     * @param sl the symbolic link that will be added to the repository content
     */
	public void addSymbolicLinkToRepository(Repository r, SymLink sl);
	
	/**
	 * Starts an Http Server on given port. It contains routes to all elements in the FileSystem
	 * 
	 * @param port
	 */
	public void startServer(int port);
	
}
