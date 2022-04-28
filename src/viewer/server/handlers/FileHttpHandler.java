package viewer.server.handlers;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import FileSystem.File;

/**
 * Http handler for Files
 * 
 * @author Quentin RIDEL
 *
 */
public class FileHttpHandler implements HttpHandler {
	
	private File file;
	
	public FileHttpHandler(File f) {
		file = f;
	}
	

	@Override
	public void handle(HttpExchange t) throws IOException {
		Headers responseHeaders = t.getResponseHeaders();
        responseHeaders.add("Content-Type", "application/octet-stream");
        String response = new String(file.getContent(), StandardCharsets.UTF_8);
        t.sendResponseHeaders(200, response.getBytes().length);
        OutputStream os = t.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
