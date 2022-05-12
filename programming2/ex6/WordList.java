import java.io.File;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class WordList {
	private List<String> words;
	private String tempWord;
	
	public WordList(String file) {
		try {
			File myFile = new File(file);
			words = new ArrayList<String>();
			Scanner scanner = new Scanner(myFile);
			while (scanner.hasNextLine()) {
				tempWord = scanner.nextLine();
				words.add(tempWord.toUpperCase());
			}
			scanner.close();
		}
		catch (Exception e) {
			System.out.println("File path " + file + " invalid!");

		}
	}
	
	public void setWords(List<String> words) {
		this.words = words;
	}

	public String getTempWord() {
		return tempWord;
	}

	public void setTempWord(String tempWord) {
		this.tempWord = tempWord;
	}

	public List<String> giveWords() {
		return words;
	}
	
	@Override
	public String toString() {
		return "WordList words = " + words;
	}
}
