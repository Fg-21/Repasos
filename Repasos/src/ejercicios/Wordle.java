package ejercicios;

import java.util.Random;
import java.util.Scanner;

public class Wordle {

	//word pool
	static String [] wordPool = {"drugs", "shoes", "thong" };
	static String word;
	static String usersWord;
	
	public static void main(String[] args) {
		//Scanner
		Scanner sc = new Scanner(System.in);
		
		//user guess
		String guess = "";
		
		//Attemps
		final int ATTEMPTS = 6;
		
		//attempts remaining
		int remainigAttps = ATTEMPTS;
		
		//win condition
		boolean win = false;
		
		//Select random word form pool
		selectRandomWord();
		
		//Inicialice the user word
		for (int i = 0; i < word.length(); i++) {
			usersWord += "_";
		}
		
		do {
			//Ask the user a word
			System.out.println("Introduce your guess");
			guess = sc.nextLine().toLowerCase();
			
			//give feedback
			System.out.println(feedback(guess));
			
			//subtract attempt
			remainigAttps--;
			
			System.out.println(remainigAttps);
			
			//Check win condition
			if (guess.equals(word)) {
				win = true;
			}
			
		} while (!win && remainigAttps > 0);
		
		if (win) {
			System.out.println("YOU WIIIIIIIIIN!");
		} else {
			System.out.println("You loose :(");
		}
	}
	
	static void selectRandomWord() {
		//Random
		Random rand = new Random();

		//Random number
		int num;
		
		//Apply the random to the number
		num = rand.nextInt(0, wordPool.length);
		
		//Randomize the words choice
		word = wordPool[num];
	}
	
	static String feedback(String guess){
		//Cadena resultante
		String cadena = "";
		
		//Variable para el caracter de la palabra y de la adivinacion 
		char wordChar;
		char guessedChar;
		
		//recorremos la palabra caracter a caracter 
		for (int i = 0; i < word.length(); i++) {
			wordChar = word.charAt(i);
			guessedChar = guess.charAt(i);
			
			if (wordChar == guessedChar) {
				cadena += guessedChar;
			}else if (word.contains(Character.toString(guessedChar))) {
				cadena += "*";
			} else {
				cadena += "_";
			}
		}
		
		
		//Devolvemos la cadena resultante
		return cadena;
				
				
			
		
		
	}
}
