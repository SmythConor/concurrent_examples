import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface for calculating the factorial of a number
 */
public interface FactorialInterface extends Remote {
	public int fact(int x) throws RemoteException;
}
