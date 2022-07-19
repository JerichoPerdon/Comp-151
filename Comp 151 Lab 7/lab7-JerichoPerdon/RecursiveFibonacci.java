
/**
 * A class holding different recursive methods to compute Fibonacci numbers.
 * 0, 1, 1, 2, 3, 5, 8, ...
 * 
 * @author Charles Hoot
 * @version 5.0
 */
public class RecursiveFibonacci
{


    /**
     * basic - The simple version of Fibonacci.
     * 
     * @param  n   A positive integer. 
     * @return     The nth Fibonacci number.
     */
    public long basic(long n)
    {
        long result = 1;
        
        if( n <= 0)
            result = 0;
        else if (n == 1)
            result = 1;
        else
            result = basic(n-1) + basic(n-2);
        
        return result;
    }
    
    
    /**
     * better - A better version of fibonacci. (Height Limited Double Recursion)
     * 
     * @param  n   A positive integer.
     * @return     The nth fibonacci number.
     */
    public long better(long n)
    {
        long result = 0;
        // IMPLEMENT THIS RECURSIVE METHOD
        

        

        return result;
    }


    /**
     * tailRecursive - A tail recursive version of fibonacci. 
     *              (Height limited, Two problems per level)
     * 
     * @param  n   A positive integer. 
     * @return     Tge nth fibonacci number.
     */
    public long tailRecursive(long n)
    {
        // IMPLEMENT THIS METHOD USING A RECURSIVE HELPER FUNCTION
        // AND RETURN AN APPROPRIATE VALUE
        if((n < 2))
        {
            return n;
        }

        //if((n > 1))
        //{
            //return tailRecursive(n - 1) + tailRecursive(n - 2);
            // n = (n - 1) + (n - 2);
            // return n;
        //}
        
        // STOPS TEST AT fibonacci(48)
        return tailRecursive(n - 1) + tailRecursive(n - 2);
    } 
    

    /**
     * secondMSB - Determine the value of the second most significant bit.
     * 
     * @param  n   A positive integer 
     * @return     True if the second most significant bit is 1, false otherwise.
     */    
    public boolean secondMSB(long n)
    {
        // IMPLEMENT THIS METHOD AND RETURN AN APPROPRIATE VALUE
        
        if(n == 1)
        {
            return true;
        }else{
            return false;
        }


    }


    /**
     * reduceBy2ndMSB - Reduce the number by removing the second most significant bit
     * from the representation.
     * 
     * @param  n   A positive integer greater than 1
     * @return     The integer value equivalent to removing the 2nd most significant bit
     *              from n.
     */    
    public long reduceBy2ndMSB(long n)
    {
        long result = 1;
        // IMPLEMENT THIS METHOD
        if(!(n > result))
        {
            result = result - (n - 2);
        }
        
        return result;
    }
    
    
}
