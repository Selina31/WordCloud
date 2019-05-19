///////////////////////////////////////////////////////////////////////////////
//Main Class File:  WordCloudGenerator.java
//File:             KeyWord.java
//Semester:         Spring 2018
//
//Author:           Xuetong Du xdu49@wisc.edu
//CS Login:         xuetong
//Lecturer's Name:  Charles Fischer
//
///////////////////////////////////////////////////////////////////////////////

/**
 * Description: The keyWord class consists of a word in lower case and an
 * integer to represent the number of occurrences of the word
 *
 * <p>
 * Bugs: none
 *
 * @author Xuetong Du
 */
public class KeyWord implements Comparable<KeyWord>, Prioritizable {

	public String word;
	public int occur;

	/**
	 * Constructor Constructs a KeyWord with the given word (converted to
	 * lower-case) and zero occurrences.
	 * 
	 * @param word
	 *            the word for this KeyWord
	 */
	public KeyWord(String word) throws IllegalArgumentException {
		this.word = word.toLowerCase();
		this.occur = 0;
	}

	/**
	 * Returns the number of occurrences the key word has
	 * 
	 * @return int the priority for this item
	 */
	@Override
	public int getPriority() {

		return occur;
	}

	/**
	 * Compares the KeyWord with the one given
	 * 
	 * @return int a number to show if the keyword is the given word
	 * @param other
	 *            the KeyWord with which to compare this KeyWord
	 */
	@Override
	public int compareTo(KeyWord other) {
		// TODO Auto-generated method stub

		return this.word.compareToIgnoreCase(other.word);
	}

	/**
	 * Compares this KeyWord to the specified object
	 * 
	 * @return boolean true if the KeyWord object whose word is the same as the word
	 *         of this KeyWord, ignoring case differences
	 * @param other
	 *            the object with which to compare this KeyWord
	 */
	@Override
	public boolean equals(Object other) {
		if (other instanceof KeyWord && word.equalsIgnoreCase(((KeyWord) other).getWord())) {
			return true;
		}
		return false;

	}

	/**
	 * Get the word for this keyWord
	 * 
	 * @return String word for this keyWord
	 */
	public String getWord() {
		return word;
	}

	/**
	 * Get the number of occurrences for this keyWord
	 * 
	 * @return int the number of occurrences for this keyWord
	 */
	public int getOccurrences() {

		return occur;
	}

	/**
	 * Increment the occurrence
	 */
	public void increment() {
		occur++;
	}

}
