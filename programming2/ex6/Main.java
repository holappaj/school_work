import java.util.Scanner;

public class Main {
	public static void main(String [] args) {
		Scanner reader = new Scanner(System.in);	
		System.out.println("Welcome to Hangman!");
		System.out.println("Please give path to textfile with words");
		String tempPath = reader.nextLine();
		
		//String tempPath = "C:\\workspace\\ohjelmointi2\\wordfile.txt";
		WordList words = new WordList(tempPath);
		
		//Comment lower line out to check all words in textfile
		//System.out.println(words);
		
		//If someone is very brave they can choose 1 false guess
		System.out.println("How many false guesses will you tolerate? Minimum 1");
		int amount = reader.nextInt();
		while (amount < 1) {
			System.out.println("If you're brave you can play with one false guess, but you can't go under");
			System.out.println("Give new false guess amount:");
			amount = reader.nextInt();
		}
		
		Hangman game = new Hangman(words, amount);
		System.out.println("Let's play!");
		System.out.println("If you type a string with more than one character, the first one is taken as your guess");
		while (game.theEnd() == false) {
			char guess;
			System.out.println("\nWord: " + game.playersWord());
			System.out.println("Guesses Left: " + game.guessesLeft());
			System.out.println("Guessed Characters: " + game.guesses());
			System.out.println("Your Next Guess: ");
			guess = reader.next().charAt(0);

			if (game.guess(guess) == true) {
				System.out.println("\nYour guess is in the word");
			}
			else {
				System.out.println("\nYour guess was not in the word");
			}
		}
		reader.close();
		
		//winLoose returns true if the two words match (shown word and game word)
		boolean winLoose = (game.playersWord().equals(game.word()));
		if (winLoose) {
			System.out.println("You win");
			System.out.println("The correct word was: " + game.word());
		}
		else {
			System.out.println("You loose");
			System.out.println("The correct word was: " + game.word());
		}
	}
}
