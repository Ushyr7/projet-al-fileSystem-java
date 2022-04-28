package viewer.server.handlers;

import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class IndexHandler implements HttpHandler {

	@Override
	public void handle(HttpExchange t) throws IOException {
		 //Create a response form the request query parameters
        String response = "<h1> Accueil </h1>"
        		+"<div>"
        		+"<p> Vous pouvez obtenir le contenu de votre système de fichier en ajoutant le chemin dans l'url !</p>"
        		+ "<p> Par exemple : </p>"
        		+ "<ul>"
        		+ "<li> http://localhost:8000/index/root/ </li>"
        		+ "</ul>"
        		+"</div>";
        //Set the response header status and length
        t.sendResponseHeaders(200, response.getBytes().length);
        //Write the response string
        OutputStream os = t.getResponseBody();
        os.write(response.getBytes());
        os.close();
	}

}
