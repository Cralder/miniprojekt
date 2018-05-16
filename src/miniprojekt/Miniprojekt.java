package miniprojekt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class Miniprojekt {

	static int totalLength = 0;
	
	
	public static double comparePlagiarism(MyHashtable in1, MyHashtable in2)
	{
		Iterator<CountNode> itr1 = in1.iterator();
		Iterator<CountNode> itr2 = in2.iterator();
		int totalCount = 0;
		int totalAmount = 0;
		
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

		
		double retValue = totalCount / (in1.size() + in2.size());
		
		return retValue;
		
	}
	
	
	public static MyHashtable readFile(Scanner scan, Iterator<CountNode> itr)
	{
		String current;
		MyHashtable table = new MyHashtable();

		while(scan.hasNextLine())
		{
			current = scan.nextLine();

			String[] temp = current.split("\\t|,|;|\\.|\\?|!|-|:|@|\\[|\\]|\\(|\\)|\\{|\\}|_|\\*|/");
			
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
						
					}else {
						
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
			
			//System.out.println(keywords.next());
			

			
			while(keywords.hasNext())
			{
				keywordTable.put(keywords.next());
			}
			
			
			MyHashtable in1Table = readFile(in1, itr);
			int total1 = totalLength;
			totalLength = 0;
			

			itr = keywordTable.iterator(); //Testa om n�t g�r fel
			int total2 = totalLength;


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
