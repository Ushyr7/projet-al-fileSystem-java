package viewer.server.handlers;

import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import FileSystem.SymLink;

/**
 * Http handler for Files
 * 
 * @author Quentin RIDEL
 *
 */
public class SymLinkHttpHandler implements HttpHandler {
	
	private SymLink sl;
	
	public SymLinkHttpHandler(SymLink s) {
		sl = s;
	}
	

	@Override
	public void handle(HttpExchange t) throws IOException {
		Headers responseHeaders = t.getResponseHeaders();
        String response = sl.getPath();
        t.sendResponseHeaders(200, response.getBytes().length);
        OutputStream os = t.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
