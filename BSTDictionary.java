import java.util.Iterator;

///////////////////////////////////////////////////////////////////////////////
//Main Class File:  WordCloudGenerator.java
//File:             BSTDictionary.java
//Semester:         Spring 2018
//
//Author:           Xuetong Du xdu49@wisc.edu
//CS Login:         xuetong
//Lecturer's Name:  Charles Fischer
//
///////////////////////////////////////////////////////////////////////////////

/**
 * Description: The BSTDictionary class implements the DictionaryADT operations
 * using a binary search tree
 *
 * <p>
 * Bugs: none
 *
 * @author Xuetong Du
 */
public class BSTDictionary<K extends Comparable<K>> implements DictionaryADT<K> {
	private BSTnode<K> root; // the root node
	private int numItems; // the number of items in the dictionary

	/**
	 * Constructor the constructor of BSTDictionary class
	 * 
	 */
	public BSTDictionary() {
		this.root = root;
		this.numItems = numItems;
	}

	/**
	 * Insert a value into the binary research tree
	 * 
	 * @param key
	 *            that will be inserted
	 */
	public void insert(K key) throws DuplicateException {
		root = insert(root, key);

	}

	/**
	 * Helper routine for insert method, which covers the case when insert into an
	 * empty BST
	 * 
	 * @param n
	 *            the root node
	 * @param key
	 *            the key node
	 * @return n the root node of BSTnode
	 */
	private BSTnode<K> insert(BSTnode<K> n, K key) throws DuplicateException {
		if (n == null) {
			numItems++;
			return new BSTnode<K>(key, null, null);
		}
		// throw exception if duplicate insertion
		if (n.getKey().compareTo(key) == 0) {
			throw new DuplicateException();
		}

		// if key less than the value in n, insert it to
		// left subtree, else to the right
		if (key.compareTo(n.getKey()) < 0) {
			n.setLeft(insert(n.getLeft(), key));
			return n;
		} else {
			n.setRight(insert(n.getRight(), key));
			return n;
		}
	}

	/**
	 * Delete the value from the tree
	 * 
	 * @param key
	 *            to search through the tree
	 * @return true if the node has been deleted successfully
	 */
	public boolean delete(K key) {
		if (lookup(key) != null) {
			root = delete(root, key);
			numItems--;
			return true;
		}
		return false;
	}

	/**
	 * Delete the value from tree
	 * 
	 * @param n
	 *            the root node of the tree to be searched
	 * @param key
	 *            to search through the tree
	 * @return n the new node after deletion
	 */
	private BSTnode<K> delete(BSTnode<K> n, K key) {
		if (n == null) {
			return null;
		}
		if (key.compareTo(n.getKey()) == 0) {
			// if n is a leaf (has no child)
			if (n.getLeft() == null && n.getRight() == null) {
				return null;
			}
			// if n has only right child
			if (n.getLeft() == null) {
				return n.getRight();
			}
			// if n has only left child
			if (n.getRight() == null) {
				return n.getLeft();
			}
			/*
			 * if n has both children, find and use the smallest value in the right subtree
			 * to replace n, and then delete the smallest value at the original place
			 */
			K smallValue = smallest(n.getRight());
			n.setKey(smallValue);
			n.setRight(delete(n.getRight(), smallValue));
		}
		return n;
	}

	/**
	 * Find the smallest value in the subtree rooted at n
	 * 
	 * @param n
	 *            the root node
	 * @return the smallest value
	 */
	private K smallest(BSTnode<K> n) {
		// n is not null from precondition
		if (n.getLeft() == null) {
			return n.getKey();
		} else {
			return smallest(n.getLeft());
		}
	}

	/**
	 * Find the particular value in the tree
	 * 
	 * @param key
	 *            to search through the tree
	 * @return
	 */
	public K lookup(K key) {
		return lookup(root, key);
	}

	/**
	 * Helper routine for lookup method
	 * 
	 * @param n
	 *            the root node of the tree to be searched
	 * @param key
	 *            to search through the tree
	 * @return the key found in the tree
	 */
	private K lookup(BSTnode<K> n, K key) {
		if (n == null) {
			return null;
		}

		if (n.getKey().compareTo(key) == 0) {

			return n.getKey();
		}

		if (n.getKey().compareTo(key) < 0) {
			// look in left subtree
			return lookup(n.getRight(), key);
		} else {

			return lookup(n.getLeft(), key);
		}
	}

	/**
	 * See if the tree is empty
	 * 
	 * @return true if the tree is empty
	 */
	public boolean isEmpty() {
		if (numItems == 0) {
			return true;
		}
		return false;
	}

	/**
	 * Return the size of the tree
	 * 
	 * @return tree size
	 */
	public int size() {
		return numItems;
	}

	public int totalPathLength() {

		return totalPathLength(root, 1);

	}

	private int totalPathLength(BSTnode<K> root, int depth) {
		if (root == null) {
			return 0;
		}
		int path = depth;
		if (root.getLeft() == null && root.getRight() == null) {
			return path;
		}
		if (root.getLeft() != null) {
			path = path + totalPathLength(root.getLeft(), depth + 1);
		}

		if (root.getRight() != null) {
			path = path + totalPathLength(root.getRight(), depth + 1);
		}
		return path;

	}

	public Iterator<K> iterator() {
		return new BSTDictionaryIterator<K>(root);
	}
}
