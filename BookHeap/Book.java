import java.io.Serializable;

/**
 * The Book class represents a standard book, consisting of a title
 */
public class Tome implements Cloneable, Comparable, Serializable {
	private String title;

	Tome(String title) {
		this.title = title;
	}

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	/**
	 * @param o the object that is being compared against the instance of Book that
	 *          called it.
	 * @return a value that corresponds to whether the value compared is less,
	 *         greater, or equal to the value calling this method.
	 */
	public int compareTo(Object o) {
		String anotherString = ((Tome) o).title;
		return this.title.compareTo(anotherString);
	}

	@Override
	public String toString() {
		return title;
	}
}
