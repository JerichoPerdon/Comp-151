
/**
 * The counter class implements a counter that will roll over to the initial
 * value when it hits the maximum value.
 * 
 * @author Charles Hoot 
 * @version 5.0
 */
public class Counter
{
    // PUT PRIVATE DATA FIELDS HERE
    private int maximum;
    private int minimum;
    private int counter;
    private boolean rolledOver;

    /**
     * The default constructor for objects of class Counter.  Minimum is 0 and the maximum
     * is the largest possible integer.
     */
    public Counter()
    {
        // ADD CODE FOR THE CONSTRUCTOR
        minimum = 0;
        maximum = Integer.MAX_VALUE; // constant that specifies that stores the maximum possible value for any integer variable in Java
        counter = 0;
        rolledOver = false;
    }
    
    
    /**
     * The alternate constructor for objects of class Counter.  The minimum and maximum values are given as parameters.
     * The counter starts at the minimum value.
     * @param min The minimum value that the counter can have
     * @param max The maximum value that the counter can have
     * */
    public Counter(int min, int max)
    {
        // ADD CODE FOR THE ALTERNATE CONSTRUCTOR
        if (min >= max)
        {
            throw new CounterInitializationException("Minimum should be less than Maximum. "); // Since Minimum can't be greater
        }

        this.minimum = min;
        this.maximum = max;
        this.counter = min;

    }
    
    /**
     * Determine if two counters are in the same state
     *
     * @param  otherObject   the object to test against for equality
     * @return     true if the objects are in the same state
     */
    public boolean equals(Object otherObject)
    {
        boolean result = true;
        if (otherObject instanceof Counter)
        {
            // YOUR CODE GOES HERE - CHANGE 
            Counter count = (Counter) otherObject;
            result = (count.minimum == minimum 
            && count.maximum == maximum 
            && count.counter == counter 
            && count.rolledOver == rolledOver);
        }
        return result;
    }
    
    

    /**
     * Increases the counter by one
     */
    public void increase()
    {
        // ADD CODE TO INCREASE THE VALUE OF THE COUNTER
        if (this.counter == this.maximum)
        {
            this.counter = minimum;
            rolledOver = true;
        }else{
            this.counter++;
        }
        
    }
 
 
     /**
     * Decreases the counter by one
     */
    public void decrease()
    {
        // ADD CODE TO INCREASE THE VALUE OF THE COUNTER
        if (this.counter == this.minimum)
        {
            this.counter = maximum;
            rolledOver = true;
        }else{
            this.counter--;
        }
    }
    
    /**
     * Get the value of the counter
     *
     * @return     the current value of the counter
     */
    public int value()
    {
        // CHANGE THE RETURN TO GIVE THE CURRENT VALUE OF THE COUNTER
        return this.counter;
		
    }
    
    
    /**
     * Accessor that allows the client to determine if the counter
     *             rolled over on the last count
     *
     * @return     true if the counter rolled over
     */
    public boolean rolledOver()
    {
        // CHANGE THE RETURN TO THE ROLLOVER STATUS OF THE COUNTER
        return this.rolledOver;
    }
    
    /**
     * Override the toString method to provide a more informative
     * description of the counter
     *
     * @return     a descriptive string about the object
     */
    public String toString()
    {
        // CHANGE THE RETURN TO A DESCRIPTION OF THE COUNTER
        return "Counter Value: " + counter + 
        "\nMinimum: " + this.minimum + 
        "\nMaximum: " + this.maximum +
        "\nRolled Over: " + this.rolledOver;		
    }
 
}
