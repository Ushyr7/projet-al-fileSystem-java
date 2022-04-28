package viewer.server;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

import FileSystem.File;
import FileSystem.Repository;
import FileSystem.SymLink;
import FileSystem.Impl.SimpleRootImpl;
import viewer.server.handlers.FileHttpHandler;
import viewer.server.handlers.IndexHandler;
import viewer.server.handlers.RepositoryHttpHandler;
import viewer.server.handlers.SymLinkHttpHandler;

/**
 * a Simple implemantation of FileSytemHttpServer
 * 
 * @author Quentin RIDEL
 *
 */
public class SimpleHttpServer implements FileSystemHttpServer {
	
	private static final String BASE_URL ="/index/";
	
    private HttpServer httpServer;
    
    private SimpleRootImpl root;
    
    public SimpleHttpServer(int port) {
    		root = SimpleRootImpl.instance();
    	try { 
            httpServer = HttpServer.create(new InetSocketAddress(port), 0);
            
            //creating index
            httpServer.createContext(BASE_URL, new IndexHandler());
            //creating all files routes
            for(String str : root.getFiles().keySet()) {
            	File f = root.getFiles().get(str);
            	httpServer.createContext(BASE_URL + str, new FileHttpHandler(f));
            }
            //creating all repositories routes
            for(String str : root.getRepositories().keySet()) {
            	Repository r = root.getRepositories().get(str);
            	httpServer.createContext(BASE_URL + str, new RepositoryHttpHandler(r));
            }
          //creating all symbolic links routes
            for(String str : root.getSymLinks().keySet()) {
            	SymLink sl = root.getSymLinks().get(str);
            	httpServer.createContext(BASE_URL + str, new SymLinkHttpHandler(sl));
            }
            httpServer.setExecutor(null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	@Override
	public void start() {
		httpServer.start();
	}

}
