package hw1;

import java.util.Arrays;

import dsUtils.WordReader;

public class WordFrequencyAnalyzer {
	/**********************************************************************************/
	/* You are not allowed to add any fields to this class beyond the one given below */
	/* You may only read in from the file once.  This means you may only use a single */
	/* word reader object.                                                            */
	/**********************************************************************************/
	
	// Currently, the field counters is not used.
	// Your task is to make this class more efficent by storing the word counts
	// as a symbol table / map / dictionary in the field counters.
	private SequentialSearchST<String, Integer> counters;
	
	private String filename;
	
	
	/**
	 * Stores a count of the number of times any word appears in a file.  The file is
	 * read in exactly once at the time time this object is constructed.
	 * (You need to modify the constructor to do this.)
	 * 
	 * @param filename the name of the file on which to count all word occurrences.
	 */
	public WordFrequencyAnalyzer(String filename) {
		this.filename = filename;
	}
	
	/**
	 * Returns the number of times a given word appears in the file from which this
	 * object was created.
	 * (Currently, it reads through the entire file to count the number of times
	 * the given word appears.  Modify this to instead use the information stored
	 * in the counters field.)
	 * 
	 * @param word the word to count
	 * @return the number of times <code>word</code> appears.
	 */
	public int getCount(char[] word) {
		WordReader r = new WordReader(filename);
		int count = 0;
		for(char[] w : r) {
			if (Arrays.equals(w, word))
				count++;
		}
		return count;
	}
	
	/**
	 * Returns the maximum frequency over all words in the file from which this
	 * ojbect was created.
	 * (Currently, this method is not implemented.  You must implement it.)
	 * 
	 * @return the maximum frequency of any word in the the file.
	 */
	public int maxCount() {
		throw new RuntimeException("Not implemented.");
	}
}
