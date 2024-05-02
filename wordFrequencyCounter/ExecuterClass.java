package wordFrequencyCounter;

//this class executes the process that homework instructions tells
public class ExecuterClass {
	private Text<Word> text;
	private Dictionary<Word> dictionary;
	private RareWordsDictionary<Word> rareWordsDictionary;
	private FrequentWordsDictionary<Word> frequentWordsDictionary;
	private MostFrequentWordsDictionary<Word> mostFrequentWordsDictionary;
	
	//constructor for the class
	public ExecuterClass() {
		text = new Text<>();
		dictionary = new Dictionary<>();
		rareWordsDictionary = new RareWordsDictionary<>();
		frequentWordsDictionary = new FrequentWordsDictionary<>();
		mostFrequentWordsDictionary = new MostFrequentWordsDictionary<>();
	}
	
	public void execute() {
		//getting data from the text file
		FileIO.readFile(text, dictionary);
		//separate method
        text.separate(dictionary, rareWordsDictionary, frequentWordsDictionary, mostFrequentWordsDictionary);

        //printing the values that homework instructions wants
        System.out.println("Text: " + dictionary.getCurrentSize() + " words");
        System.out.print("Text content: ");
        dictionary.displayItems();
        System.out.println();
        System.out.println("Rare Words Dictionary: " + rareWordsDictionary.getCurrentSize() + " words");
        System.out.print("Rare Words Dictionary content: ");
        rareWordsDictionary.displayItems();
        System.out.println();
        System.out.println("Frequent Words Dictionary: " + frequentWordsDictionary.getCurrentSize() + " words");
        System.out.print("Frequent Words Dictionary content: ");
        frequentWordsDictionary.displayItems();
        System.out.println();
        System.out.println("Most Frequent Words Dictionary: " + mostFrequentWordsDictionary.getCurrentSize() + " words");
        System.out.print("Most frequent Words Dictionary content: ");
        mostFrequentWordsDictionary.displayItems();

	}
}
