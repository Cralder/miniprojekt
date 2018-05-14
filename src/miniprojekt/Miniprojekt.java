package miniprojekt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Hashtable;
import java.util.Scanner;

public class Miniprojekt {

	public static void main(String[] args) {
		
		Hashtable<String, Integer> table = new Hashtable<String, Integer>();
		
		try {
			Scanner keywords = new Scanner(new File("src\\miniprojekt\\javanyckelord.txt"));
			Scanner cmd = new Scanner(System.in);
			Scanner in1 = new Scanner(new File(cmd.next()));
			Scanner in2 = new Scanner(new File(cmd.next()));
			cmd.close();
			System.out.println(keywords.next());
			
			String current;
			String keyword;
			
			while(in1.hasNext()) {
				current = in1.next();
				
				while(keywords.hasNext()) {
					keyword = keywords.next();
					
					if(current.equals(keyword)) {
						table.put(keyword, 1);
					}
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
