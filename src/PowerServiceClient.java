import java.math.BigInteger;

import java.rmi.RMISecurityManager;
import java.rmi.Naming;

import java.rmi.RemoteException;
import java.rmi.NotBoundException;
import java.net.MalformedURLException;

/**
 * client to handle calls to power service server
 */
public class PowerServiceClient {
	public static void main(String[] args) {
		/* Set up the security manager */
		System.setSecurityManager(new RMISecurityManager() {
				public void checkConnect(String host, int port) {}
				public void checkConnect(String host, int port, Object context) {}
		});

		/* Declare the name */
		String name = "rmi://127.0.0.1:9999/power-service";

		PowerService powerService = null;

		try {
			/* initialise powerservice with the rmi lookup */
			powerService = (PowerService) Naming.lookup(name);
		} catch(NotBoundException e) {
			e.printStackTrace();
		} catch(MalformedURLException e) {
			e.printStackTrace();
		} catch(RemoteException e) {
			e.printStackTrace();
		}

		try {
			int number = 10;

			/* Square the number */
			BigInteger numberSq = powerService.square(number);

			System.out.println(numberSq);
		} catch(RemoteException e) {
			e.printStackTrace();
		}

		try {
			int num1 = 10;
			int num2 = 10;

			/* raise num1 to power of num2 */
			BigInteger num1P = powerService.power(num1, num2);

			System.out.println(num1P);
		} catch(RemoteException e) {
			e.printStackTrace();
		}
	}
}
