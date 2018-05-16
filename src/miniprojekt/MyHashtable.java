package miniprojekt;

import java.util.Iterator;

class MyHashtable {
	
	public CountNode[] table;
	private int size;
	
	/**
	 * Class constructor with initial capacity
	 */
	public MyHashtable(int initialcapacity) {
		table = new CountNode[initialcapacity];
	}
	
	/**
	 * Class constructor that decides the size of the table
	 */
	public MyHashtable() {
		this(127);
	}
	
	/**
	 * Returns the node in the table at index i
	 * @param i The index to in which place to return the node from
	 * @return Returns a node from the table
	 */
	public CountNode getNode(int i) {
		return table[i];
	}
	
	/**
	 * Method to insert a node in the hashtable. It checks if the index is larger than the hashtable, if it doubles the 
	 * hashtables length and then creates a node in which the String and index becomes its values. If the index already is 
	 * occupied it will be raised to a power 2 and try again with that index. If the string value is the same it will 
	 * only increment a count value inside the node to represent how many of the words it has put in. 
	 * @param s A word that is to be put in a node that has been read
	 * @param i Index in which position to add the node in the hashtable
	 */
	public void put(String s, int i) {
		
		if(i > table.length) {
			CountNode[] temp = new CountNode[table.length*2];
			for(int j = 0; j<table.length; j++) {
				temp[j] = table[j];
			}
			table = temp;
			put(s, i);
			
		}else{
			if(table[i] == null) {
				table[i] = new CountNode(s, 1);
				size++;
			}else if(table[i].getString().equals(s)) {
				table[i].inc();
				size++;
			}else {
				put(s, i++);
			}
			
		}
		
	}
	
	/**
	 * The size of the hashtable
	 * @return The size of the hashtable
	 */
	
	public int size() {
		return size;
	}
	
	/**
	 * Put but without the index value. If it does not give a index the index will be a hash value of the word
	 * @param s A word that is to be put in a node that has been read
	 */
	
	public void put(String s) {
		put(s, new CountNode(s,1).hashCode());
	}
	
	/**
	 * Method find that will find the index of the given string and index of the hashed value of string
	 * @param s The string that you search for
	 * @param i Will be the hashvalue of the String
	 * @return The index of the given string, -1 if the string isn't present
	 */
	
	public int find(String s, int i) {
		if(i > table.length) {
			return -1;
		}else if(table[i].getString().equals(s)) {
			return i;
		}else {
			return find(s, i++);
		}
	}
	
	/**
	 * Find method that searches for a given string value. The string value will be hashed and then searched for in the
	 * other find method recursively 
	 * @param s The string value you search for
	 * @return Given index of the given string value
	 */
	
	public int find(String s) {
		return find(s, new CountNode(s,1).hashCode());
	}
	
	/**
	 * Gives the iterator of the CountNode class that iterates through the table
	 * @return Iterator of type CountNode
	 */
	
	public Iterator<CountNode> iterator(){
		return new HashIterator();
	}
	
	/**
	 * Method find that will find the index of the given string and index of the hashed value of string  
	 * @param s The string value you search for
	 * @return True if the given string value exists in the hashtable, otherwise false
	 */
	
	public boolean findBool(String s, int i) {
		if(i > table.length) {
			return false;
		}else if(table[i].getString().equals(s)) {
			return true;
		}else {
			return findBool(s, i^2);
		}
	}
	
	/**
	 * Find method that searches for a given string value. The string value will be hashed and then searched for in the
	 * other find method recursively 
	 * @param s The string value you search for
	 * @return True if the given string value exists in the hashtable, otherwise false
	 */
	public boolean findBool(String s) {
		return findBool(s,new CountNode(s,1).hashCode());
	}
	
	
	
	
	private class HashIterator implements Iterator<CountNode>{
		
		private int count = 0;
		
		
		/**
		 * Class constructor
		 */
		public HashIterator(){
			if(table.length == 0){
				throw new InvalidSizeException();
			}
		}
		
		/**
		 * (non-Javadoc)
		 * @see java.util.Iterator#hasNext()
		 */
		public boolean hasNext() {
			
			for(int i = count; i < table.length; i++) {
				if(table[i] != null) {
					return true;
				}
			}
			
			return false;
		}
		/**
		 * (non-Javadoc)
		 * @see java.util.Iterator#next()
		 */
		public CountNode next() {
			CountNode out = null;
			
			while(out == null && count<table.length) {
				out = table[count];
				count++;
			}
			return out;
		}
		/**
		 * (non-Javadoc)
		 * @see java.util.Iterator#remove()
		 */
		public void remove() {}
	
	}
	
	
}
