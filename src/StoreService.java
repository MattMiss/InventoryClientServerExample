import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 Executes Simple Inventory Management Protocol commands
 from a socket.
 */

public class StoreService implements Runnable{

    private Socket s;
    private Scanner in;
    private PrintWriter out;
    private Store store;

    /**
     Constructs a service object that processes commands from a socket for a store.
     @param aSocket the socket
     @param aStore the store
     */
    public StoreService(Socket aSocket, Store aStore){
        s = aSocket;
        store = aStore;
    }

    public void run(){
        try{
            try{
                in = new Scanner(s.getInputStream());
                out = new PrintWriter(s.getOutputStream());
                doService();
            }finally{
                s.close();
            }
        }catch(IOException exception){
            exception.printStackTrace();
        }
    }

    /**
     Executes all commands until the QUIT command or the end of input.
     */
    public void doService() throws IOException{
        while(true){
            if (!in.hasNext()) { return; }
            String command = in.next();
            if (command.equals("QUIT")) { return; }
            else { executeCommand(command); }

        }
    }

    /**
     Executes a single command
     @param command the command to execute
     */
    public void executeCommand(String command){
        String product = in.next();

        if (command.equals("ADD")){
            int count = in.nextInt();
            store.add(product, count);
        }else if (command.equals("REMOVE")){
            int count = in.nextInt();
            store.remove(product, count);
        }else if (command.equals("DISCOUNT")){
            double percent = in.nextDouble();
            store.setDiscount(product, percent);
        }else if (command.equals("NODISCOUNT")){
            store.removeDiscount(product);
        }else if (!command.equals("INFO")){
            out.println("Invalid command");
            out.flush();
            return;
        }
        out.println(product + " - " + "Count: " + store.getCount(product) + ", Cost: " + store.getCost(product) + ", With Discount: " + store.getDiscountedCost(product));
        out.flush();
    }
}
