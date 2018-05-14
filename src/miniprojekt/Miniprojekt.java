package miniprojekt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Scanner;

public class Miniprojekt {
	
	static int totalLength = 0;
	
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
	 
	
	
	public static void main(String[] args) {
		
		MyHashtable keywordTable = new MyHashtable();
		Iterator<CountNode> itr = keywordTable.iterator();
		
		try {
			Scanner keywords = new Scanner(new File("src\\miniprojekt\\javanyckelord.txt"));
			Scanner cmd = new Scanner(System.in);
			Scanner in1 = new Scanner(new File(cmd.next()));
			Scanner in2 = new Scanner(new File(cmd.next()));
			cmd.close();
			System.out.println(keywords.next());
			

			
			while(keywords.hasNext())
			{
				keywordTable.put(keywords.next());
			}
			
			
			MyHashtable in1Table = readFile(in1, itr);
			int total1 = totalLength;
			totalLength = 0;
			
			itr = keywordTable.iterator(); //Testa om nåt går fel
			int total2 = totalLength;

			
			MyHashtable in2Table = readFile(in2, itr);
			
			
			
			
				

			
			
			in1.close();
			in2.close();
			keywords.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}

}
