package wordFrequencyCounter;
import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class FileIO {
	//getting data from text file
	public static void readFile(Text<Word> text, Dictionary<Word> dictionary) {
		
		try {
			File file = new File("text.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String wordContent = scanner.next().replaceAll("[^a-zA-Z]", "").toLowerCase();
                Word word = new Word(wordContent);
                text.add(word);
            }
			scanner.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
