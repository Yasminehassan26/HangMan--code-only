package eg.edu.alexu.csd.datastructure.hangman;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Hangman implements IHangman {
String[] words=new String[100000];
public int attempts=0;
public String[]array;
private String Secretword ;
private char[] Secret2;
private char[] Secret1;
 public int error=0;
 public int d=0;
public int j=0;
	private BufferedReader br;
	public String[] read () throws IOException {
		

		try {
		br = new BufferedReader(new FileReader("dictionary.txt"));
		String line=br.readLine();
		while(line!=null && (j< words.length) ) {
			if (line.length()!=0) {
			words[j]=line.toLowerCase();
			j++;
		}
			line=br.readLine();
	
	} br.close();
  }
		  catch (IOException e) {
		      System.out.println("An error occurred.");
		    } return words;
	}
	@Override
	public void setDictionary(String[] words)  {
		// TODO Auto-generated method stub;	
		
		try {
			array= read();
			for (int i = 0; i < array.length; i++) {
		          words[i] = array[i];	}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
} 

	@Override
	public String selectRandomSecretWord() {
		// TODO Auto-generated method stub
		Random r=new Random();
		int randomNumber=r.nextInt(j);
		Secretword =words[randomNumber];
		 Secret1 = Secretword.toCharArray();
		 Secret2 = Secretword.toCharArray();
			
	for (int index = 0; index < Secretword.length(); index++){
			        Secret2[index] = '-';
			}
		return words[randomNumber];
		
	}

	@Override
	public String guess(Character c) throws Exception {
		// TODO Auto-generated method stub
		int i;
		
		String Guess1 ;
		
		if(Secretword.matches("[a-zA-Z]*$")	) {
	
	c=Character.toLowerCase(c);

		int count=0;
		for(i=0;i<Secretword.length();i++) {
		if (c==Secret1[i] ) {
			
			Secret2[i]=c;
			 d++;
			 count=1;
			 Guess1= String.valueOf(Secret2);}
			
		}

		//System.out.println(Secret2);

		if(count==0) {
			if(Character.isLetter(c)) {	
			    System.out.println("Wrong guess");
				error++;
				}
				else if (!Character.isLetter(c)) {
					System.out.println("Wrong input");
				}
			
		}else {System.out.println("good guess");}
		
		
		}
		
		
		else {
			throw new Exception("Error");
		}
		 Guess1= String.valueOf(Secret2);
			return Guess1;	
		
	}

	@Override
	public void setMaxWrongGuesses(Integer max) {
		
		if (max==null) {
			max=1;
		}
		attempts=max;
		
	}
	public static void main(String[] args) throws Exception {
   Hangman game = new Hangman();
	Scanner sc = new Scanner(System.in);  
   game.setDictionary(game.words);
   game.selectRandomSecretWord();
 //  System.out.println(game.Secretword+"   (to be sure that it works correctly)");

   System.out.println("Enter the number of maximum errors:");
   int max1 = sc.nextInt();
   game.setMaxWrongGuesses(max1);
   System.out.println(game.Secret2);

	try {	while(game.d<game.Secretword.length()&& (game.error<game.attempts)) {
			   System.out.println("Enter the letter:");

		char c = sc.next().charAt(0);
       
    	   game.guess(c) ;
   		System.out.println(game.Secret2);

       }}
	catch(Exception e) {
		System.out.println("error found :Buggy word");
	}if(game.d==(game.Secretword.length())) {
		System.out.println("Good job : you won");
	}
	else if (game.error==(game.attempts)) {
		System.out.println("Hard Luck!");
	}
System.out.println("game over");}
} 
	
 

	

