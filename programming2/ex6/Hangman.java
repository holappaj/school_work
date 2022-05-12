import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hangman {
	private int guessAmount, tempLength;
	private ArrayList<Character> guessedLetters = new ArrayList<Character>();
	private String guessableWord, shownWord = "";
	
	public Hangman (WordList wordList, int guessAmount) {
		this.guessAmount = guessAmount;
		Random rand = new Random();
		this.guessableWord = wordList.giveWords().get(rand.nextInt(wordList.giveWords().size()));
		this.tempLength = guessableWord.length();
		//add as many "_" as the length is
		for (int i=0; i<tempLength; i++) {
			this.shownWord += "_";
		}
	}
	
	public boolean guess(Character charac) {
		//change to uppercase for ease
		char guess = Character.toUpperCase(charac);
		if (this.guessableWord.contains(Character.toString(guess))) {
			this.guessedLetters.add(guess);
			for (int i=0; i<tempLength; i++) {
				if (this.guessableWord.charAt(i) == guess) {
					//keeps the substring as it is, adds guessed character to index i and then keep rest of the substring intact
					//https://www.geeksforgeeks.org/replace-a-character-at-a-specific-index-in-a-string-in-java/
					this.shownWord = shownWord.substring(0, i) + guess + shownWord.substring(i + 1);
				}
			}
			return true;
		}
		else {
			//false guess added to guessed letters and allowed false guesses -1
			this.guessedLetters.add(guess);
			this.guessAmount -= 1;
			return false;
		}
	}
	
	public List<Character> guesses() {
		return guessedLetters;
	}
	
	public int guessesLeft() {
		return guessAmount;
	}
	
	public String word() {
		return guessableWord;
	}

	public String playersWord() {
		return this.shownWord;
	}
	public boolean theEnd() {
		// games keeps on going until the word no longer contains "_" or if the guesses left go to zero
		if (shownWord.contains("_") && (this.guessesLeft() > 0)) {
			return false;
		}
		else {
			return true;
		}
	}
}
