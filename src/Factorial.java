import java.rmi.Remote;
import java.rmi.RemoteException;

import java.io.Serializable;

/**
 * Implementation of the factorial interface
 */
public class Factorial implements FactorialInterface, Serializable {
	static final long serialVersionUID = 42L;

	public Factorial() {}

	/**
	 * Get the factorial of a number
	 * @param x
	 * @return the factorial as an int
	 */
	@Override
	public int fact(int x) throws RemoteException {
		if(x == 1) {
			return x;
		}

		return x * fact(x - 1);
	}
}
