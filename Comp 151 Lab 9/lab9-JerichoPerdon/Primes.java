import java.io.*;
import java.util.*;

/**
 * Primes is a program that will compute prime numbers using the sieve of Eratosthenes.
 * 
 * @author Charles Hoot
  * @version 5.0
 */

    
public class Primes
{

    public static void main(String args[])
    {

        int max;
        
        System.out.println("Please enter the maximum value to test for primality");
        max = getInt("   It should be an integer value greater than or equal to 2.");
        
        // COMPLETE THE MAIN

        // Step 2: In main declare and create the candidates list. Add in the values.
        ListInterface<Integer> candidates;

        candidates = new AList<Integer>(max);
        for(int i = 1; i <= max; i++)
        {
            candidates.add(i, i);
        }

        // Step 3: Print out the candidates list
        System.out.println("Candidates: " + candidates);

        // Step 4: In main declare and create the primes and composites lists.
        ListInterface<Integer> primes = new AList<Integer>(max);
        ListInterface<Integer> composites = new AList<Integer>(max);


        // Step 11: Wrap the code from steps 5 through 8 in a while loop that continues as long as the candidates list is not empty.
        while(!candidates.isEmpty())
        {
            // Step 5: Remove the first values from the primes list and remember it in a variable
            int removedFirstPrime = candidates.remove(1);

            // Step 6: Print out the prime that was discovered
            System.out.println("Removed first prime value: " + removedFirstPrime);

            // Step 7: Add it to the primes lists
            primes.add(1, removedFirstPrime);

            // Step 10: Between the code from steps 7 and 8, call getComposites().
            getComposites(candidates, composites, removedFirstPrime);

            // Step 8: Print out all three lists
            System.out.println("Candidate List:" + candidates);
            System.out.println("Primes List:" + primes);
            System.out.println("Composites List:" + composites);
        }
        

        
    }
    
    
    /**
     * getComposites - Remove the composite values from possibles list and
     * put them in the composites list.
     *
     * @param  candidates   A list of integers holding the possible values.
     * @param  composites   A list of integers holding the composite values.
     * @param  prime   An Integer that is prime.
     */
    public static void getComposites(ListInterface<Integer> candidates, ListInterface<Integer> composites, Integer prime)
    {
        // COMPLETE THIS METHOD

        // Step 9: Complete the getComposites() method. To determine if one integer value is divisible by another, you can use the modulus operator (% in Java).
        for(int i = 1; i <= candidates.getLength(); i++)
        {
            if(candidates.getEntry(i) % prime == 0)
            {
                composites.add(candidates.getEntry(i));
                candidates.remove(i);
            }
        }
    }
    
    
    
    
    /**
     * Get an integer value.
     *
     * @return     An integer. 
     */
    private static int getInt(String rangePrompt)
    {
        Scanner input;
        int result = 10;        //Default value is 10
        try
        {
            input = new Scanner(System.in);
            System.out.println(rangePrompt);
            result = input.nextInt();
            
        }
        catch(NumberFormatException e)
        {
            System.out.println("Could not convert input to an integer");
            System.out.println(e.getMessage());
            System.out.println("Will use 10 as the default value");
        }        
        catch(Exception e)
        {
            System.out.println("There was an error with System.in");
            System.out.println(e.getMessage());
            System.out.println("Will use 10 as the default value");
        }
        return result;
                                    
    }    
    
}
