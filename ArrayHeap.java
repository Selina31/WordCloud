import java.util.NoSuchElementException;
///////////////////////////////////////////////////////////////////////////////
//Main Class File:  WordCloudGenerator.java
//File:             ArrayHeap.java
//Semester:         Spring 2018
//
//Author:           Xuetong Du xdu49@wisc.edu
//CS Login:         xuetong
//Lecturer's Name:  Charles Fischer
//
///////////////////////////////////////////////////////////////////////////////

/**
 * Description: The ArrayHeap class implements the PriorityQueueADT interface
 * using an array-based implementation of a max heap as well as other methods
 *
 * <p>
 * Bugs: none
 *
 * @author Xuetong Du
 */

public class ArrayHeap<E extends Prioritizable> implements PriorityQueueADT<E> {

	// default number of items the heap can hold before expanding
	private static final int INIT_SIZE = 100;
	private E[] data;
	private int size;

	/**
	 * A no-argument constructor that constructs a heap whose underlying array has
	 * enough space to store INIT_SIZE items before needing to expand.
	 */
	public ArrayHeap() {
		this(INIT_SIZE);
	}

	/**
	 * a 1-argument constructor that takes an integer parameter and constructs a
	 * heap whose underlying array has enough space to store the number of items
	 * given in the parameter before needing to expand. If the parameter value is
	 * less 0, an IllegalArgumentException is thrown.
	 * 
	 * @param iniSize
	 *            the initial size
	 */
	@SuppressWarnings("unchecked")
	public ArrayHeap(int initSize) {
		if (initSize < 0) {
			throw new IllegalArgumentException();
		}
		// Initial the array and size
		data = (E[]) (new Prioritizable[initSize + 1]);
		size = 0;
	}

	/**
	 * Check if the array size is empty
	 * 
	 * @return size the size of the array
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Insert a value into the array heap
	 * 
	 * @param item
	 *            that will be inserted
	 */
	public void insert(E item) {
		// if array is full, arraySize*2 && copy the original
		if (data.length == size + 1) {
			E[] newD = (E[]) new Prioritizable[data.length * 2];
			System.arraycopy(data, 0, newD, 0, data.length);
			data = newD;
		}

		data[++size] = item;

		int child = size;
		while (data[child / 2] != null && data[child / 2].getPriority() < data[child].getPriority()) {
			// swap the value up when parent is less
			E tmp = data[child / 2];
			data[child / 2] = data[child];
			data[child] = tmp;

			// swap again
			child = child / 2;
		}
	}

	/**
	 * Swap the root with the last child and set the last child to null in order to
	 * remove the maximum data
	 * 
	 * @return rootMax the maximum value that has been removed
	 */
	public E removeMax() {
		// throw exception if heap is null
		if (size == 0) {
			throw new NoSuchElementException();
		}
		// To store root and return
		E rootMax = data[1];

		// set root to be the last child, and last child to null
		data[1] = data[size];
		data[size--] = null;

		int parent = 1;
		while ((parent * 2 + 1) <= data.length && data[parent * 2] != null && data[parent * 2 + 1] != null) {
			// if child > parent, swap
			E tmp = data[parent];
			// if both children > parent, swap the bigger child with parent
			if (data[parent * 2].getPriority() > data[parent].getPriority()
					&& data[parent * 2 + 1].getPriority() > data[parent].getPriority()) {
				// if left > right, swap left with parent
				if (data[parent * 2].getPriority() > data[parent * 2 + 1].getPriority()) {
					data[parent] = data[parent * 2];
					data[parent * 2] = tmp;
					parent *= 2;
				} else {
					data[parent] = data[parent * 2 + 1];
					data[parent * 2 + 1] = tmp;
					parent = parent * 2 + 1;
				}
			} else if (data[parent * 2].getPriority() > data[parent].getPriority()) {
				// only the left child > parent
				data[parent] = data[parent * 2];
				data[parent * 2] = tmp;
				parent *= 2;
			} else {
				// only the right child > parent
				data[parent] = data[parent * 2 + 1];
				data[parent * 2 + 1] = tmp;
				parent = parent * 2 + 1;
			}
		}
		return rootMax;
	}

	/**
	 * Get the maximum value
	 * 
	 * @return the root value
	 */
	public E getMax() {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		return data[1];
	}

	/**
	 * Size of the array heap
	 * 
	 * @return the size
	 */
	public int size() {
		return size;
	}
}
