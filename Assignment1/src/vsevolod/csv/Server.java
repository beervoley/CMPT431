package vsevolod.csv;


import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server implements RemoteObj {

    public static int DEFAULT_PORT = 5555;

    private Server() {
    }

    public long getTime() {
        return System.currentTimeMillis();
    }

    public static void main(String[] args) {
        try {
            Server server = new Server();
            RemoteObj stub = (RemoteObj) UnicastRemoteObject.exportObject(server, DEFAULT_PORT);
            Registry registry = LocateRegistry.createRegistry(DEFAULT_PORT);
            registry.bind("RemoteObj", stub);
            System.err.println("Server ready");

        } catch(Exception e) {
            System.err.println("Server excpetion: " + e.toString());
            e.printStackTrace();
        }
    }
}
