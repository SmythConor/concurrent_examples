import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.RMISecurityManager;

public class FactorialClient {
	public static void main(String[] args) {
		System.setSecurityManager(new RMISecurityManager() {
			public void checkConnect(String host, int port) {}
			public void checkConnect(String host, int port, Object context) {}
		});

		String name = "rmi://127.0.0.1:9999/fact";
		FactorialInterface factorialInterface = null;

		try {
			factorialInterface = (FactorialInterface) Naming.lookup(name);
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			int number = 5;

			int result = factorialInterface.fact(number);

			System.out.println(result);
		} catch(RemoteException e) {
			e.printStackTrace();
		}
	}
}
