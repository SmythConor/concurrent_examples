import java.io.Serializable;

import java.math.BigInteger;

import java.rmi.Naming;

import java.rmi.RemoteException;
import java.rmi.AlreadyBoundException;
import java.net.MalformedURLException;

/**
 * Server to handle the power service interface
 */
public class PowerServiceServer implements PowerService, Serializable {
	static final long serialVersionUID = 42L;

	public PowerServiceServer() {}

	public static void main(String[] args) {
		/* Create a name for the endpoint */
		String name = "rmi://127.0.0.1:9999/power-service";

		/* Create and instance of this object */
		PowerServiceServer powerServiceServer = new PowerServiceServer();

		try {
			/* Bind the endpoint to an instance of this object */
			Naming.bind(name, powerServiceServer);

			System.out.println("Server started");
		} catch(AlreadyBoundException e) {
			e.printStackTrace();
		} catch(MalformedURLException e) {
			e.printStackTrace();
		} catch(RemoteException e) {
			e.printStackTrace();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public BigInteger square(int number) throws RemoteException {
		Long longNumber = new Long(number);

		BigInteger num = new BigInteger(String.valueOf(number));// BigInteger.valueOf(longNumber);

		return num.pow(2);
	}

	/**
	 * {@inheritDoc}
	 */
	public BigInteger power(int num1, int num2) throws RemoteException {
		Long longNum1 = new Long(num1);

		BigInteger n1 = new BigInteger(String.valueOf(num1));//BigInteger.valueOf(longNum1);

		return n1.pow(num2);
	}
}
