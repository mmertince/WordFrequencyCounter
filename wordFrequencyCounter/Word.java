package wordFrequencyCounter;

public class Word {
	
	private String content;
	private int length;
	
	//parameterized constructor
	public Word(String wordContent) {
		setContent(wordContent);
		setLength(wordContent.length());
	}
	//implementation of toString method
	public String toString() {
		return getContent();
	}
	//implementation of equals method
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
		    return false;
		Word other = (Word) obj;
		    return content.equals(other.content);
	}
	//getters and setters
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

}
