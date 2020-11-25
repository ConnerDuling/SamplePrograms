import java.util.Arrays;

public class MaxHeap implements Cloneable {
	// Total size of the main array, including the null values that can be given
	// values if needed.
	private int capacity = 10;

	// total items within the array.
	private int size = 0;

	Book[] Books = new Book[capacity];

	/**
	 * Creates a MaxHeap object that is empty.
	 */
	MaxHeap() {
	}

	/**
	 * Takes an array and creates a MaxHeap object with them.
	 * @param array the array that has the elements to be added to the heap.
	 */
	MaxHeap(Book[] array) {
		buildHeap(array);
	}

	/**
	 * 
	 * @param first  index for the first item to swap.
	 * @param second index for the second item to swap.
	 */
	private void swap(int first, int second) {
		Book temp = null;
		try {
			temp = (Book) Books[first].clone();
			Books[first] = (Book) Books[second].clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Books[second] = temp;
	}

	/**
	 * Adds a Book object into the heap.
	 * @param added the Book object to be added.
	 */
	public void addBook(Book added) {
		ensureCapacity();
		Books[size] = added;
		size++;
		heapifyUp();
	}

	/**
	 * Removes the maximum value from the heap.
	 * @return returnRoot Book object that is the Maximum of the heap and come last alphabetically
	 */
	public Book removeMax() {

		// If there is no root in the heap, or it's empty.
		if (Books[0] == null)
			return null;

		Book returnRoot = null;
		try {
			// Set aside the root to return at the end.
			returnRoot = (Book) Books[0].clone();
			// Move the item at the end of the array to the root.
			Books[0] = (Book) Books[size - 1].clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Books[size - 1] = null;
		if (size > 0)
			size--;
		heapifyDown();

		return returnRoot;
	}

	/**
	 * Creates a heap with an array of Book objects, whether or not they are sorted.
	 * @param array of Book objects to be turned into a heap.
	 */
	public void buildHeap(Book[] array) {
		for (Book book : array) {
			if(book != null)
			this.addBook(book);
		}
	}

	/**
	 * Checks the size of the array, and if need be, doubles the size plus one to allow for more elements.
	 */
	private void ensureCapacity() {
		if (size == capacity) {
			Books = Arrays.copyOf(Books, capacity * 2 + 1);
			capacity = capacity * 2 + 1;
		}
	}

	/**
	 * Grabs the most recently inserted item, size -1, and shuffles it up in the tree until the
	 * only node below it is less, and the one above it is greater.
	 */
	private void heapifyUp() {
		int index = size - 1;
		while (hasParent(index) && (parent(index).compareTo(Books[index]) < 0)) {
			swap(getParentIndex(index), index);
			index = getParentIndex(index);
		}
	}

	/**
	 * Grabs the root and shuffles it down, such as needed when the max is removed.
	 */
	private void heapifyDown() {
		int index = 0;
		while (hasLeftChild(index)) {
			int largestChildIndex = getLeftChildIndex(index);
			if (hasRightChild(index) && (rightChild(index).compareTo(leftChild(index)) > 0)) {
				largestChildIndex = getRightChildIndex(index);
			}

			if (Books[index].compareTo(Books[largestChildIndex]) > 0) {
				break;
			} else {
				swap(index, largestChildIndex);
			}
			index = largestChildIndex;
		}
	}
	
	/**
	 * Prints out the the heap proper. Without any sorting applied.
	 */
	@Override
	public String toString() {
		String output = "";

		for (int i = 0; i < size; i++) {
			
				output += Books[i].toString() + ", ";
			
		}

		return output;

	}

	public Book[] sortedHeap() {
		
		MaxHeap sorted = new MaxHeap(Books);
		Book[] returnBooks = new Book[size];
		
		for(int i = size -1; i >= 0; i--) {
			returnBooks[i] = sorted.removeMax();
		}
		
		
		return returnBooks;
		
	}
	
	public String sortedPrint() {
		Book[] sortedArray = sortedHeap();
		String output = "";
		
		for(Book books : sortedArray) {
			output += books.toString() + ", ";
		}
		
		return output;
	}
	
	//Various getters for the index of children and parent nodes, as well as checks to
	//ensure they exist within the heap's array.
	
	private int getLeftChildIndex(int parentIndex) {
		return 2 * parentIndex + 1;
	}

	private int getRightChildIndex(int parentIndex) {
		return 2 * parentIndex + 2;
	}

	private int getParentIndex(int childIndex) {
		return (childIndex - 1) / 2;
	}

	private boolean hasLeftChild(int index) {
		return getLeftChildIndex(index) < size;
	}

	private boolean hasRightChild(int index) {
		return getRightChildIndex(index) < size;
	}

	private boolean hasParent(int index) {
		return getParentIndex(index) >= 0;
	}

	private Book leftChild(int index) {
		return Books[getLeftChildIndex(index)];
	}

	private Book rightChild(int index) {
		return Books[getRightChildIndex(index)];
	}

	private Book parent(int index) {
		return Books[getParentIndex(index)];
	}
}
