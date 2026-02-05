package backend;

import com.sun.net.httpserver.*;

import java.io.IOException;
import java.net.InetSocketAddress;

public class myServer {
    static boolean running = false;
    public static void main(String[] args) throws IOException {
        var server = HttpServer.create();
        server.bind(new InetSocketAddress("192.168.100.110", 3000), 0);
        server.start();

        http
    }
}
