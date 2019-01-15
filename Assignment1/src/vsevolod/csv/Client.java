package vsevolod.csv;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by vsevolod on 2019-01-14.
 */
public class Client {

    public static void main(String[] args) {

        String host = "127.0.0.1";
        try {
            Registry registry = LocateRegistry.getRegistry(host, Server.DEFAULT_PORT);
            RemoteObj stub = (RemoteObj) registry.lookup("RemoteObj");
            long time = System.currentTimeMillis();
            long response = stub.getTime();
            long delay = (System.currentTimeMillis() - time)/2;
            response += delay;
            DateFormat df = new SimpleDateFormat("dd MMM yyyy hh:mm:ss zzz");
            System.out.println("Server time is: " + df.format(new Date(response)));

        } catch(Exception e) {
            System.out.println("Server excpetion: " + e.toString());
            e.printStackTrace();
        }

    }
}
