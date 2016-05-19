import java.io.Serializable;

/**
 * Addition object to implement addition
 */
public class Addition implements AdditionInterface, Serializable {
	static final long serialVersionUID = 42L;

	public Addition() {}

	/**
	 * Add the two number and return
	 * @param x the first number
	 * @param y the second number
	 * @return x added to y
	 */
	@Override
	public int add(int x, int y) throws Exception {
		return x + y;
	}
}
