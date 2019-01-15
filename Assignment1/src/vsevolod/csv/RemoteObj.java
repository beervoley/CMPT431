package vsevolod.csv;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by vsevolod on 2019-01-14.
 */
public interface RemoteObj extends Remote {
    long getTime() throws RemoteException;
}
