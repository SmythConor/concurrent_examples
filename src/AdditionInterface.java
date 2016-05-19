import java.rmi.Remote;

/**
 * Addition interface to be implemented by server and client
 */
public interface AdditionInterface extends Remote {
	public int add(int x, int y) throws Exception;
}
