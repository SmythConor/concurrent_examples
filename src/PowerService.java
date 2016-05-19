import java.math.BigInteger;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface for implementation
 */
public interface PowerService extends Remote {
	/**
	 * Square the given number
	 * @param number the number to square
	 * @return squared number as BigInteger
	 */
	public BigInteger square(int number) throws RemoteException;

	/**
	 * Raise num1 to the power of num2
	 * @param num1 the base
	 * @param num2 the power
	 * @return powered number as BigInteger
	 */
	public BigInteger power(int num1, int num2) throws RemoteException;
}
