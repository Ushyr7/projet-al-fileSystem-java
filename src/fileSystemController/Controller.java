package fileSystemController;

import FileSystem.File;
import FileSystem.Repository;
import FileSystem.Root;
import FileSystem.SymLink;
import FileSystem.Impl.SimpleRootImpl;
import factories.FileSystemElementsFactory;
import factories.SimpleFileSystemElementsImplFactory;
import viewer.server.FileSystemHttpServer;
import viewer.server.SimpleHttpServer;

public class Controller implements IController {
	
	private Root root;
	private FileSystemElementsFactory factory;
	private FileSystemHttpServer server;
	
	public Controller() {
		root = SimpleRootImpl.instance();
		factory = new SimpleFileSystemElementsImplFactory();
	}
	

	@Override
	public Root getRoot() {
		return root;
	}

	@Override
	public File createFile(String name) {
		return factory.createFile(name);
	}

	@Override
	public Repository createRepository(String name) {
		return factory.createRepository(name);
	}

	@Override
	public SymLink createSymbolicLink(String name, String path) {
		return factory.createSymLink(name, path);
	}

	@Override
	public void addFileToRepository(Repository r, File f) {
		r.addFile(f);
		//mise à jour du dossier dans la map repositories
		String Path = root.getElementPath(r);
		root.addToRepositories(Path, r);
		//ajout du fichier dans la map files
		root.addToFiles(Path + "/" + f.getName(), f);
	}

	@Override
	public void addRepositoryToRepository(Repository container, Repository r) {
		container.addRepository(r);
		//mise à jour du dossier dans la map repositories
		String BaseRepoPath = root.getElementPath(container);
		root.addToRepositories(BaseRepoPath, container);
		//ajout du dossier dans la map repositories
		root.addToRepositories(BaseRepoPath + "/" + r.getName(), r);
	}

	@Override
	public void addSymbolicLinkToRepository(Repository r, SymLink sl) {
		r.addSymLink(sl);
		//mise à jour du dossier dans la map repositories
		String repoPath = root.getElementPath(r);
		root.addToRepositories(repoPath, r);
		//ajout du lien symbolique dans la map symbolicLinks
		root.addToSymbolicLinks(repoPath + "/" + sl.getName(), sl);
	}

	@Override
	public void startServer(int port) {
		server = new SimpleHttpServer(port);
		server.start();
		System.out.println("Server is started on port "+ port);
		System.out.println("You can find it here :");
		System.out.println("http://localhost:" + port +"/index/");
	}

}
