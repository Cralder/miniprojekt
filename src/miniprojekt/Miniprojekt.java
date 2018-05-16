

package miniprojekt;

import java.io.File;
import java.io.FileNotFoundException;
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
		
		double retValue = totalCount / completeLength;
		
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
	
	public static MyHashtable readFile(Scanner scan, Iterator<CountNode> itr)
	{
		String current;
		MyHashtable table = new MyHashtable();

		while(scan.hasNext())
		{
			current = scan.next();
<<<<<<< HEAD
=======

			String[] temp = current.split("\\|,|;|\\.|\\?|!|-|:|@|\\[|\\]|\\(|\\)|\\{|\\}|_|\\*|/");
>>>>>>> fa6fa2fbedd2cf2dbaf677446d662d1de86440be

			
			for(int i = 0; i<temp.length; i++) {
				System.out.println(temp[i]);
			}
			
			for(int i = 0; i < temp.length; i++)
			{
				
				CountNode currentKeyword;
				while(itr.hasNext())
				{
					currentKeyword = itr.next();
					
					if(!currentKeyword.getString().equals(temp[i]))
					{
						table.put(temp[i]);
						totalLength++;
						
					} else {
						
						totalLength++;
						
					}
				}
			}
			
		}
		return table;
	}
	 
	public static void print(Scanner file1, Scanner file2, double comp){
		System.out.println(file1 + " och " + file2 + " har " + comp + "% gemensamma identifierare");
	}
	
	public static void main(String[] args) {
		
		MyHashtable keywordTable = new MyHashtable();
		Iterator<CountNode> itr = keywordTable.iterator();
		
		try {
			Scanner keywords = new Scanner(new File("src\\miniprojekt\\javanyckelord.txt"));
			Scanner cmd = new Scanner(System.in);
			Scanner in1 = new Scanner(new File(cmd.next()));
			Scanner in2 = new Scanner(new File(cmd.next()));
			cmd.close();
			         
			while(keywords.hasNext())
			{
				keywordTable.put(keywords.next());
			}
			
			
			MyHashtable in1Table = readFile(in1, itr);
			int total1 = totalLength;
			totalLength = 0;
			

			itr = keywordTable.iterator(); //Testa om n�t g�r fel
			int total2 = totalLength;

			
			completeLength = total1 + total2;

			itr = keywordTable.iterator(); //Testa om n�got g�r fel

			MyHashtable in2Table = readFile(in2, itr);

			
			print(in1, in2, comparePlagiarism(in1Table, in2Table));


			keywords.close();
			in1.close();
			in2.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}

}
