# Word Frequency Counter

A Java console application that reads a text file and sorts its words into **rare**, **frequent** and **most frequent** dictionaries based on how often each word appears. It is built on a hand-written generic **Bag ADT** (array-based, resizable) instead of the Java Collections Framework.

Built as HW1 for the **CENG 112** course.

## How It Works

1. `FileIO` reads `text.txt` word by word, strips every non-letter character and lower-cases the result.
2. Each word is stored in a `Text` bag. Duplicates are allowed, so the bag keeps the raw word stream.
3. `Text.separate(...)` takes words out of the bag one by one and counts how often each distinct word occurred. It then puts the word into one dictionary:

   | Dictionary | Frequency |
   | --- | --- |
   | `RareWordsDictionary` | fewer than 5 |
   | `FrequentWordsDictionary` | 5 – 8 |
   | `MostFrequentWordsDictionary` | more than 8 |

4. The program prints the size and contents of the text dictionary and of each frequency dictionary.

### Sample Output Format

```
Text: <n> words
Text content: ...
Rare Words Dictionary: <n> words
Rare Words Dictionary content: ...
Frequent Words Dictionary: <n> words
Frequent Words Dictionary content: ...
Most Frequent Words Dictionary: <n> words
Most frequent Words Dictionary content: ...
```

## The Bag ADT

`IBag<T>` defines the interface and `Bag<T>` implements it with a generic array:

- `add`, `remove()`, `remove(T)`, `removeByIndex(int)`, `clear`
- `contains`, `getFrequencyOf`, `getIndexOf`, `isEmpty`, `isFull`, `getCurrentSize`
- `toArray`, `displayItems`
- Starts with a capacity of 25 and **doubles automatically** when full, up to a maximum of 1000 entries.

All dictionaries (`Dictionary`, `RareWordsDictionary`, `FrequentWordsDictionary`, `MostFrequentWordsDictionary`) and `Text` extend `Bag`.

## Running

You need a Java Development Kit (JDK 8 or newer).

1. Put the text you want to analyze into a file named **`text.txt`** in the directory you run the program from. The file is not included in the repository.
2. Compile and run from the repository root:

```bash
javac -d out wordFrequencyCounter/*.java
java -cp out wordFrequencyCounter.WordFrequencyCounter
```

> **Note:** the Bag has a hard limit of 1000 entries, so very large input files will exceed it.

## Project Structure

```
wordFrequencyCounter/
├── WordFrequencyCounter.java        # Entry point (main)
├── ExecuterClass.java               # Runs the pipeline and prints results
├── FileIO.java                      # Reads and normalizes words from text.txt
├── IBag.java / Bag.java             # Generic Bag ADT interface and implementation
├── Text.java                        # Raw word stream + separate() logic
├── Word.java                        # Word value object (content, length, equals)
├── Dictionary.java                  # All words processed
├── RareWordsDictionary.java         # Frequency < 5
├── FrequentWordsDictionary.java     # Frequency 5–8
└── MostFrequentWordsDictionary.java # Frequency > 8
```

## Authors

- Ezgi Erdal
- Mustafa Mert İnce
- Elif Burcu Keskin
