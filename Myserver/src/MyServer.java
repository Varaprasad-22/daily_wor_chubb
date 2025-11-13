import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class MyServer {
    public static void main(String[] args) throws IOException {
        int port = 8082; // Port number
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        System.out.println("Server started at http://localhost:" + port);

        server.createContext("/api/hello", new HelloHandler());
        server.setExecutor(null); // Default executor
        server.start();
    }

    static class HelloHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = "{\"message\": \"Hello from Eclipse server!\"}";
            exchange.getResponseHeaders().set("Content-Type", "application/json");
            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
