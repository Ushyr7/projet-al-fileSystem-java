package viewer.server.handlers;

import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import FileSystem.FileSystemElements;
import FileSystem.Repository;

/**
 * Http Handler for Repositories
 * 
 * @author Quentin RIDEL
 *
 */
public class RepositoryHttpHandler implements HttpHandler {

	private Repository repo;
	
	public RepositoryHttpHandler(Repository r) {
		repo = r;
	}
	

	public Repository getRepo() {
		return repo;
	}


	@Override
	public void handle(HttpExchange t) throws IOException {
        String response = createResponseFromRepositoryContent();
        t.sendResponseHeaders(200, response.getBytes().length);
        OutputStream os = t.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
	
	public String createResponseFromRepositoryContent() {
		String res ="<h1>" + repo.getName() + "</h1>"
				+"<ul>";
		for (FileSystemElements elem : repo.getContent()) {
			res +="<li>" +  "<a href ='" + elem.getName() + "/" + "'>" + elem.getName() + "</a> " + elem.getSize() + " octets" + "</li>";
		}
		res += "</ul>";
		return res;
	}

}
