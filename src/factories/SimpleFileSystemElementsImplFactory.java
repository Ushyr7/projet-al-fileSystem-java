package factories;

import FileSystem.Impl.SimpleFileImpl;
import FileSystem.Impl.SimpleRepositoryImpl;
import FileSystem.Impl.SimpleSymLinkImpl;
import FileSystem.File;
import FileSystem.Repository;
import FileSystem.SymLink;

/**
 * Factory to create SimpleImpl Elements
 * 
 * @author Quentin RIDEL
 *
 */
public class SimpleFileSystemElementsImplFactory implements FileSystemElementsFactory {
	
	@Override
	public File createFile(String name) {
		return new SimpleFileImpl(name);
	}

	@Override
	public Repository createRepository(String name){
		return new SimpleRepositoryImpl(name);
	}

	@Override
	public SymLink createSymLink(String name, String path) {
		return new SimpleSymLinkImpl(name, path);
	}
}
