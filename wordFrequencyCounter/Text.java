package wordFrequencyCounter;


public class Text<T extends Word> extends Bag<Word> {
	//separate method for adding the words to correct types of classes
	public void separate(Dictionary<Word> dictionary, 
			RareWordsDictionary<Word> rareWordsDictionary, 
			FrequentWordsDictionary<Word> frequentWordsDictionary, 
			MostFrequentWordsDictionary<Word> mostFrequentWordsDictionary) {
		
		while(!isEmpty()) {
			for (int i = 0; i < getCurrentSize(); i++) {
				Word word = removeByIndex(i);
            
				if (!dictionary.contains(word)) {
					int frequency = getFrequencyOf(word) + 1;
					if (frequency < 5) {
						rareWordsDictionary.add(word);
					} else if (frequency >= 5 && frequency <= 8) {
						frequentWordsDictionary.add(word);
					} else {
						mostFrequentWordsDictionary.add(word);
					}
				}
            
				dictionary.add(word);
			}
		}
		
	}

}
