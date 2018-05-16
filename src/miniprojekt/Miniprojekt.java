

package miniprojekt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Miniprojekt {
	static int completeLength = 0;
	static int totalLength = 0;
	
	/**
	 * Returns the final percentage of plagiarism in the two documents 
	 * both arguments are the MyHashtables that will be compared to eachother
	 * <p>
	 * this method compares the two MyHashTables that are inputed containing all 
	 * identifiers from the two documents you wish to compare. 
	 * the left MyHashTable is iterated and the find() method is used
	 * to search for the identifier inside of the second MyHashTable
	 * if the identifier exists within the second MyHashTable the amount of 
	 * times they are found inside both MyHashTables are summarized and added 
	 * to the total amount of found plagiarisms.
	 * 
	 * @param  in1 the first MyHashtable you want to compare with the other
	 * @param  in2 the second MyHashtable you want to compare with the first
	 * @return the percentage of plagiarism found when comparing the documents
	 */
	
	public static double comparePlagiarism(MyHashtable in1, MyHashtable in2)
	{
		Iterator<CountNode> itr1 = in1.iterator();
		int totalCount = 0;

		
		while(itr1.hasNext())
		{
			CountNode in1WordNode = itr1.next();
			String in1Word = in1WordNode.getString();

			if(in2.findBool(in1Word))
			{	
				int in2Word = in2.find(in1Word);
				
				int in1WordCount = in1WordNode.getCount();
				int in2WordCount = in2.getNode(in2Word).getCount();
				
				int countAmount = in1WordCount + in2WordCount;
				
				totalCount = totalCount + countAmount;	
			}
		}
		System.out.println("Completelength:" + completeLength);
		System.out.println("totalcount: " + totalCount);
		
		double retValue =  ((double) totalCount / (double) completeLength) * 100;
		return retValue;
		
	}
	
	/**
	 * Returns the inputed java files as MyHashTables 
	 * one argument is a scanner and the other is an iterator
	 * <p>
	 * this method uses a scanner and an iterator to iterate a java file and 
	 * split the identifiers into seperate strings which are then put
	 * into a MyHashTable. The method also uses the keyword text-file to
	 * compare with the identifiers that are scanned from the java file.
	 * If the identifier is in the keywords file it is simply added to the total length of the document
	 * 
	 * @param  scan the scanner that is used to read a java file
	 * @param  itr is an iterator that you wish to use to iterate the files
	 * @return a MyHashTable containing every identifier found inside the java file
	 * including the amount of times it occured
	 */
	
	public static MyHashtable readFile(Scanner scan, MyHashtable hashTable)
	{
		String current;
		MyHashtable table = new MyHashtable();
		
		Iterator<CountNode> itr = hashTable.iterator();

		while(scan.hasNext())
		{
			current = scan.next();
			String[] temp = current.split("\\.");
			
			for(int i = 0; i < temp.length; i++)
			{
				CountNode currentKeyword;
				boolean check = true;
				
				while(itr.hasNext())
				{
					currentKeyword = itr.next();
					
					if(currentKeyword.getString().equals(temp[i]))
					{
						check = false;
					}
				}
				if(check) {
					table.put(temp[i]);
					totalLength++;
				}
				
				itr = hashTable.iterator();
				
			}
			
		}
		return table;
	}
	
	/**
	* Prints the filenames and the result of the comparison between the two files.  
	* @param file1 The first file
	* @param file2 The second file that the first file compares to
	* @param comp The percentage of plagiarism between file1 and file2  
	*/
	
	public static void print(String file1, String file2, double comp){
		System.out.println(" Fil 1: " + file1 + " och " + "Fil 2: " + file2 + " har " + comp + "% gemensamma identifierare");
	}
	
	public static void main(String[] args) {
		
		MyHashtable keywordTable = new MyHashtable();
		Iterator<CountNode> itr = keywordTable.iterator();
		
		try {
			Scanner keywords = new Scanner(new File("src\\miniprojekt\\javanyckelord.txt"));
			Scanner cmd = new Scanner(System.in);
			String firstpath = cmd.next();
			Scanner in1 = new Scanner(new File(firstpath));
			String secondpath = cmd.next();
			Scanner in2 = new Scanner(new File(secondpath));
			cmd.close();
			         
			/*while(keywords.hasNext())
			{
				keywordTable.put(keywords.next());
				System.out.println(keywordTable.toString());
			}*/
			

			
			
			MyHashtable in1Table = readFile(in1, keywordTable);
			int total1 = totalLength;
			totalLength = 0;


			MyHashtable in2Table = readFile(in2, keywordTable);
			int total2 = totalLength;

			completeLength = total1 + total2;
			
			print(firstpath, secondpath, comparePlagiarism(in1Table, in2Table));


			keywords.close();
			in1.close();
			in2.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}

}
