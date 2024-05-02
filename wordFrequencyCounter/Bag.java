/**
 * 
 */
package wordFrequencyCounter;

import java.util.Arrays;

//implementation of Bag ADT
public class Bag<T> implements IBag<T> {
	
	private T[] bag;
	private int numberOfEntries;
	private boolean initialized = false;
	private static final int MAX_CAPACITY = 1000;
	private static int defaultCapacity = 25;
	
	
	//consturctor
	public Bag() {
			this(defaultCapacity);
		}
	//parameterized constructor
    public Bag(int desiredCapacity) {
		
		checkCapacity(desiredCapacity);
		@SuppressWarnings("unchecked")
		T[] tempBag = (T[]) new Object[desiredCapacity];
		bag = tempBag;
		setNumberOfEntries(0);
		initialized = true;
	}
	//checking initialization
	private void checkInitialization() {
		if(!initialized) {
			throw new SecurityException("Bag object is not initialized properly.");
		}
	}
	//method for doubling capacity
	private void doubleCapacity() {
		
		int newLength = 2*bag.length;
		checkCapacity(newLength);
		bag = Arrays.copyOf(bag, newLength);
		
	}
	//method for checking capacity
	private void checkCapacity(int length) {
		
		if (length > MAX_CAPACITY) {
			throw new IllegalStateException("Attempt to create a bag whose capacity is larger than the maximum.");
		}
		
	}
	
	//method for adding new entry
	@Override
	public boolean add(T newEntry) {
		checkInitialization();
		if (isFull()) {
			doubleCapacity();
		}
		bag[getNumberOfEntries()] = newEntry;
		setNumberOfEntries(getNumberOfEntries() + 1);
		
		return true;
	}

	//method for checking is bag empty
	@Override
	public boolean isEmpty() {
		return getNumberOfEntries() == 0;
	}

	//method for checking is bag full
	@Override
	public boolean isFull() {
		return getNumberOfEntries() >= bag.length;
	}

	//method for removing an element from bag by index
	@Override
	public T removeByIndex(int index) {
		T result = null;
		if(!isEmpty() && 0 <= index && index<getNumberOfEntries()){
			result = bag[index];
			bag[index] = bag[getNumberOfEntries() - 1];
			
			bag[getNumberOfEntries() - 1] = null;
			setNumberOfEntries(getNumberOfEntries() - 1);
		}
		
		return result;
	}

	//method for removing an element from bag by entry
	@Override
	public boolean remove(T anEntry) {
		
		checkInitialization();
		int index = getIndexOf(anEntry);
		T result = removeByIndex(index);
		
		return anEntry.equals(result);
	}

	//method for removing an element from bag
	@Override
	public T remove() {
		checkInitialization();
		T result = null;
		
		if (getNumberOfEntries() > 0) {
			result = bag[getNumberOfEntries() - 1];
			bag[getNumberOfEntries() - 1] = null;
			setNumberOfEntries(getNumberOfEntries() - 1);
		}
		return result;
	}

	//method for getting an entry's frequency value
	@Override
	public int getFrequencyOf(T anEntry) {
		checkInitialization();
		int counter = 0;
		
		for (int index = 0; index < getNumberOfEntries(); index++) {
			if(anEntry.equals(bag[index])) {
				counter++;
			}
		}
		return counter;
	}

	//method for getting an entry's index
	@Override
	public int getIndexOf(T anEntry) {
		
		int where = -1;
		boolean found = false;
		int index = 0;
		
		while(!found && index < getNumberOfEntries()) {
			if(anEntry.equals(bag[index])) {
				found = true;
				where = index;
			}
			index++;
		}
		
		return where;
	}

	//method for checking whether the beg contains the special element or not
	@Override
	public boolean contains(T anEntry) {
		checkInitialization();
		return getIndexOf(anEntry) > -1;
	}

	//method for clearing the bag
	@Override
	public void clear() {
		
		while (!isEmpty()) {
			remove();
		}

	}

	//method for displaying the items in the bag
	@Override
	public void displayItems() {
		
		checkInitialization();
		T[] arr = toArray();
		for (int index = 0; index < getNumberOfEntries(); index++) {
			if(index==getNumberOfEntries()-1) {
				System.out.print(arr[index].toString());
			}
			else {
				System.out.print(arr[index].toString() + ", ");
			}
		}

	}

	//method for getting bag's current size
	@Override
	public int getCurrentSize() {
		return getNumberOfEntries();
	}

	//toArray method for ADT Bag
	@Override
	public T[] toArray() {
		
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[getNumberOfEntries()];
		
		for (int index = 0; index < getNumberOfEntries(); index++) {
			result[index] = bag[index];
		}
		return result;
	}

	//method for getting the number of entries
	public int getNumberOfEntries() {
		return numberOfEntries;
	}

	//method for setting the number of entries
	public void setNumberOfEntries(int numberOfEntries) {
		this.numberOfEntries = numberOfEntries;
	}

}
