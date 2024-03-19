import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 A server that executes the Simple Inventory Management Protocol.
 */

public class StoreServer {
    public static void main(String[] args) throws IOException{
        final int PRODUCT_LENGTH = 10;
        Store store = new Store(PRODUCT_LENGTH);
        final int SBAP_PORT = 8888;
        ServerSocket server = new ServerSocket(SBAP_PORT);
        System.out.println("Waiting for stores to connect...");

        while (true){
            Socket s = server.accept();
            System.out.println("Store connected.");
            StoreService service = new StoreService(s, store);
            Thread t = new Thread(service);
            t.start();
        }
    }
}
