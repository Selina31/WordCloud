# WordCloud
Description:

  In this assignment you will be writing a Java program that creates a word cloud for a text file. A word cloud is a way to visually represent information in a text file; key words from the text file are displayed with the importance of each word indicated by font size and/or color. For the purposes of this assignment, key words will be any words that show up in the text file that are not in a provided list of words to ignore. The importance of a word will be determined by how many times the word appears in the text file. The word cloud created from the text file will be saved to a webpage. Your program will take four command-line arguments: the name of the input text file, the name of the output file (i.e., the webpage), the maximum number of words to include in the word cloud, and the name of the text file containing the words to ignore.

  To construct the word cloud, your program will first go through the text file and determine the key words that appear and how many times each key word shows up. Each key word can be thought of as a (word, # of occurrences) pair. Note that, by definition, the words in the pairs are unique. A Dictionary is an ADT that stores unique key values and provides operations to add and remove information as well as to traverse the key values in order. This makes the Dictionary a useful ADT to store the key word information. For this program, you will implement a Dictionary ADT using a binary search tree. After collecting all the key word information, your program will find the N key words with the most occurrences to include in the word cloud (where N is the maximum number of words to include, specified by the user as a command-line argument). To do this, your program will put all the the key words into a Priority Queue (prioritized by the number of occurrences) and then remove the required number of key words. For this program, you will implement a Priority Queue using an array-based heap.

Goals:
The goals of this assignment are to:

  Code classes that implement specified interfaces.
  Gain experience using javadoc documentation to get information about a class.
  Gain more experience dealing with command-line arguments.
  Code a class that implements a Dictionary interface using a binary search tree (BST).
  Gain experience using Comparable objects and the compareTo method.
  Gain experience using a stack to implement an iterator for a binary search tree.
  Code a class that implements a PriorityQueue interface using an array-based heap.
  Gain experience reading and generating HTML files.
