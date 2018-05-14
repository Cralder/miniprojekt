package miniprojekt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Hashtable;
import java.util.Scanner;

public class Miniprojekt {

	public static void main(String[] args) {
		
		MyHashtable keywordTable = new MyHashtable();
		
		
		try {
			Scanner keywords = new Scanner(new File("src\\miniprojekt\\javanyckelord.txt"));
			Scanner cmd = new Scanner(System.in);
			Scanner in1 = new Scanner(new File(cmd.next()));
			Scanner in2 = new Scanner(new File(cmd.next()));
			cmd.close();
			System.out.println(keywords.next());
			
			String current;
			
			while(keywords.hasNext())
			{
				keywordTable.put(keywords.next());
			}
			
			while(in1.hasNext())
			{
				current = in1.nextLine();
				
				
				MyHashtable in1Table = new MyHashtable();
				String[] temp = current.split("\\t|,|;|\\.|\\?|!|-|:|@|\\[|\\]|\\(|\\)|\\{|\\}|_|\\*|/");
				
				for(int i = 0; i < temp.length; i++)
				{
					if(temp[i])
				}
				
				for(int i = 0; i < temp.length; i++) {
					in1Table.put(temp[i]);
				}
				
				
				

			}
			
			in1.close();
			in2.close();
			keywords.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}

}
