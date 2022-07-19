/**
    A class of bags whose entries are stored in a chain of linked nodes.
    The bag is never full.
    INCOMPLETE DEFINITION; includes definitions for the methods add,
    toArray, isEmpty, and getCurrentSize.
    @author Frank M. Carrano, Timothy M. Henry
    @version 5.0
    * 
    * Extra methods added for lab exercise by Charles Hoot
    * //- * @version 5.1
*/
public final class LinkedBag<T> implements BagInterface<T>
{
	private Node firstNode;       // Reference to first node
	private int numberOfEntries;

	public LinkedBag()
	{
		firstNode = null;
        numberOfEntries = 0;
	} // end default constructor

	/** Adds a new entry to this bag.
	    @param newEntry  The object to be added as a new entry.
	    @return  True. */
	public boolean add(T newEntry) // OutOfMemoryError possible
	{
      // Add to beginning of chain:
		Node newNode = new Node(newEntry);
		newNode.next = firstNode;  // Make new node reference rest of chain
                // (firstNode is null if chain is empty)
                firstNode = newNode;       // New node is at beginning of chain
		numberOfEntries++;
      
		return true;
	} // end add

	/** Retrieves all entries that are in this bag.
       @return  A newly allocated array of all the entries in this bag. */
	public T[] toArray()
	{
      // The cast is safe because the new array contains null entries.
      @SuppressWarnings("unchecked")
      T[] result = (T[])new Object[numberOfEntries]; // Unchecked cast
      
      int index = 0;
      Node currentNode = firstNode;
      while ((index < numberOfEntries) && (currentNode != null))
      {
         result[index] = currentNode.data;
         index++;
         currentNode = currentNode.next;
      } // end while
      
      return result;
      // Note: The body of this method could consist of one return statement,
      // if you call Arrays.copyOf
	} // end toArray
   
	/** Sees whether this bag is empty.
       @return  True if the bag is empty, or false if not. */
	public boolean isEmpty()
	{
		return numberOfEntries == 0;
	} // end isEmpty
   
	/** Gets the number of entries currently in this bag.
       @return  The integer number of entries currently in the bag. */
	public int getCurrentSize()
	{
		return numberOfEntries;
	} // end getCurrentSize
   

	/** Removes one unspecified entry from this bag, if possible.
       @return  Either the removed entry, if the removal
                was successful, or null. */
    public T remove() {
        T result = null;

        // MODIFY THIS METHOD TO REMOVE A RANDOM ITEM FROM THE BAG

        if (firstNode != null) {
            result = firstNode.data;
            firstNode = firstNode.next; // Remove first node from chain
            numberOfEntries--;
        } // end if


        return result;
    } // end remove


   
	/** Removes one occurrence of a given entry from this bag.
       @param anEntry  The entry to be removed.
       @return  True if the removal was successful, or false otherwise. */
	public boolean remove(T anEntry) {
        boolean result = false;
        Node nodeN = getReferenceTo(anEntry);
        if (nodeN != null) {
            nodeN.data = firstNode.data; // Teplace located entry with entry
                // in first node
            firstNode = firstNode.next; // Remove first node
            numberOfEntries--;
            result = true;
        } // end if
        return result;
    } // end remove
        
        
// Locates a given entry within this bag.
// Returns a reference to the node containing the entry, if located,
// or null otherwise.
    private Node getReferenceTo(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode;
        while (!found && (currentNode != null)) {
            if (anEntry.equals(currentNode.data)) {
                found = true;
            } else {
                currentNode = currentNode.next;
            }
        } // end while
        return currentNode;
    } // end getReferenceTo


	
	/** Removes all entries from this bag. */
    public void clear() {
        while (!isEmpty()) {
            remove();
        }
    } // end clear
	
	/** Counts the number of times a given entry appears in this bag.
		 @param anEntry  The entry to be counted.
		 @return  The number of times anEntry appears in the bag. */
    public int getFrequencyOf(T anEntry) {
        int frequency = 0;
        int loopCounter = 0;
        Node currentNode = firstNode;
        while ((loopCounter < numberOfEntries) && (currentNode != null)) {
            if (anEntry.equals(currentNode.data)) {
                frequency++;
            }
            loopCounter++;
            currentNode = currentNode.next;
        } // end while
        return frequency;
    } // end getFrequencyOf

	
	/** Tests whether this bag contains a given entry.
		 @param anEntry  The entry to locate.
		 @return  True if the bag contains anEntry, or false otherwise. */
    public boolean contains(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode;
        while (!found && (currentNode != null)) {
            if (anEntry.equals(currentNode.data)) 
                found = true;
             else 
                currentNode = currentNode.next;
        } // end while
        return found;
    } // end contains

	private class Node
	{
	  private T    data; // Entry in bag
	  private Node next; // Link to next node

		private Node(T dataPortion)
		{
			this(dataPortion, null);	
		} // end constructor
		
		private Node(T dataPortion, Node nextNode)
		{
			data = dataPortion;
			next = nextNode;	
		} // end constructor
	} // end Node

    /*********************************************************************
     * 
     * METHODS TO BE COMPLETED
     * 
     * 
     ************************************************************************/
    
    /** Check to see if two bags are equals.  
     * @param aBag Another object to check this bag against.
     * @return True if the two bags contain the same objects with the same frequencies.
     */
    public boolean equals(LinkedBag<T> aBag) {
        
        // Notes from pdf
        // we will determine if two bags are equal by comparing the frequencies of the items
        // in the bags. The main difference is that instead of using a for loop and directly 
        // accessing the entries in the bag by their index, we need to use a loop that will
        // scan over the one of the linked structures with a reference. 
        
        boolean result = false; // result of comparison of bags

        // COMPLETE THIS METHOD 

        Node scout = this.firstNode; // reference

        if (this.numberOfEntries == aBag.numberOfEntries)
        {
            for(int i = 0; i < this.numberOfEntries; i++)
            {
                int firstBagFreq = this.getFrequencyOf(scout.data);
                int secondBagFreq = aBag.getFrequencyOf(scout.data);

                if (firstBagFreq != secondBagFreq) // checks if scout has referenced every nodein bag
                {
                    result = true;
                }

                scout = scout.next; // moves scout to next node
            }
            
            result = true;
        }
        return result;
    }  // end equals

    /** Duplicate all the items in a bag.
     * @return True if the duplication is possible.
     */
    public boolean duplicateAll() {
        
        // Notes from PDF
        // We need to copy each of the items in the original bag
        // write down a loop that will scan over each position of an item in the bag
        // The body of the loop needs to create a node with the duplicate and add it to the bag
        // easiest way to do that is to put the duplicate at the front of the bag
        // what is the increase in the number of items in the bag?
        
        boolean success = true; // should always return true
                                // if there is a problem allocating nodes
                                // an exception will be thrown

        // COMPLETE THIS METHOD

        Node duplicateNode = this.firstNode;
        int duplicateEntries = this.numberOfEntries;

        for(int i = 0; i < duplicateEntries; i++)
        {
            
            this.add(duplicateNode.data);
            duplicateNode = duplicateNode.next;
            
        }

        return success;
    }  // end duplicateAll

    /** Remove all duplicate items from a bag
     */
    public void removeDuplicates() {

        // COMPLETE THIS METHOD

        // Notes from PDF
        // Instead of removing the duplicates, we will create a second chain that holds the unique entries
        // Will use nested loops: the outer loop will scan over the original chain, inner loop will scan
        // over the second chain to see if an item is already in chain
        // if item is not already in chain of unique entries add it
        // after outer loop is complete, change the firstNode reference and the numberOfEntries
        
        // a) Write an outer loop that will visit the position of each item in the chain of original items
        
        // b) Write an inner loop that scans over the second chain of unique items and determines if a given
        //  item is already in the chain

        // c) Write a chunk of code that will add the item at the front of the second chain and increments
        // the count of the number of unique items

        // d) Write a couple lines of code that change the first node so that it references the chain
        // of unique items and updates the number of entries
        
        Node originalNode = this.firstNode;
        LinkedBag<T> newChain = new LinkedBag<T>();

        while(originalNode != null) // a)
        {
            if(firstNode == originalNode.data) // b)
            {
                newChain.add(originalNode.data); // c)
            }

            originalNode = originalNode.next;
        }

        this.firstNode = newChain.firstNode; // d)
        this.numberOfEntries = newChain.numberOfEntries;
        
        return;
    }  // end removeDuplicates
} // end LinkedBag



