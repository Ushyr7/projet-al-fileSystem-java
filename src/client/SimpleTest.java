package client;


import FileSystem.File;
import FileSystem.Repository;
import FileSystem.SymLink;
import FileSystem.Impl.SimpleRootImpl;
import fileSystemController.Controller;
import fileSystemController.IController;

public class SimpleTest {
	
	public static void main(String[] args) {
		IController c = new Controller();
		SimpleRootImpl root = (SimpleRootImpl) c.getRoot();
		//creation de fichier
		File myFile = c.createFile("file1.txt");
		myFile.setContent("test".getBytes());
		File f1 = c.createFile("test.png");
		f1.setContent("ceci est un long message".getBytes());
		File f2 = c.createFile("test2.png");
		f2.setContent("42 42 42 42 42 42 42 42 42 42 42 42 42 42 42 42 42 42 42 42 42".getBytes());
		//creation de dossier
		Repository myRepo = c.createRepository("monRepo1");
		//creation de liens symbolique
		SymLink sl = c.createSymbolicLink("symlink.fr", "root/monRepo1");
		//ajout à la racine
		root.addFile(myFile);
		root.addRepository(myRepo);
		root.addSymLink(sl);
		//ajout dans le dossier
		c.addFileToRepository(myRepo, f1);
		c.addFileToRepository(myRepo, f2);
		
		//lancement du serveur
		c.startServer(8000);
		
	}

}
