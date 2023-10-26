package numberrangesummarizer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberRangeSummarizerImplTest {

    // Declare variables used in the test cases.
    private NumberRangeSummarizerImpl summarizer;
    private Collection<Integer> testRange;

    // This method is executed before each test to set up common test data.
    @BeforeEach
    public void setUp(){
        summarizer = new NumberRangeSummarizerImpl();
        testRange = new ArrayList<>();
    }

    /**
        The following unit tests ensure the collect() method can handle various test cases.
    */
    // Ensures the collect() method correctly converts a string of numbers into a collection of positive integers.
    @Test
    public void testCollect(){
        // Define the expected Collection of integers.
        testRange.add(1);
        testRange.add(2);
        testRange.add(3);

        // Call the collect() method with the input and check if the 'result' matches the expected Collection.
        Collection<Integer> result = summarizer.collect("1,2,3");
        assertEquals(testRange, result);
    }

    // Ensures the collect() method would return an empty Collection if the input String is empty.
    @Test
    public void testCollectEmptyInput(){

        Collection<Integer> result = summarizer.collect("");
        assertEquals(testRange, result); // testRange is empty as it was initialized above, but no data was added to it.
    }

    // Ensures the collect() method can handle a single integer.
    @Test
    public void testCollectSingleInteger(){

        testRange.add(42);

        Collection<Integer> result = summarizer.collect("42");
        assertEquals(testRange, result);
    }

    // Ensures the collect() method ignores spaces in a string list of numbers.
    @Test
    public void testCollectWithSpaces(){

        testRange.add(1);
        testRange.add(2);
        testRange.add(3);

        Collection<Integer> result = summarizer.collect("1, 2, 3");

        assertEquals(testRange, result);

    }

    // Ensures the collect() method ignores non-integers in the list.
    @Test
    public void testCollectNonIntegers(){

        testRange.add(1);
        testRange.add(3);
        testRange.add(7);

        Collection<Integer> result = summarizer.collect("1,a,b,3,7");

        assertEquals(testRange, result);
    }

    // Ensures the collect() method would return empty if only non-integers were in the input String.
    @Test
    public void testCollectOnlyNonIntegers(){
        Collection<Integer> result = summarizer.collect("a,b,c");

        assertEquals(testRange, result);
    }

    // Ensures the collect() method can parse zero and negative numbers to the Collection.
    @Test
    public void testCollectZeroAndNegativeIntegers(){

        testRange.add(-3);
        testRange.add(-1);
        testRange.add(0);
        testRange.add(1);
        testRange.add(3);

        Collection<Integer> result = summarizer.collect("-3,-1,0,1,3");

        assertEquals(testRange, result);

    }


    // This test case checks the summarizeCollection() method to ensure it correctly summarizes
    // a Collection on integers.
    @Test
    public void testSummarizeCollection(){

        // Define the Collection of integers to be summarized.
        testRange.add(1);
        testRange.add(2);
        testRange.add(3);
        testRange.add(6);
        testRange.add(9);

        // Call the summarizeCollection() method and check if the result matches the expected summary string.
        String result = summarizer.summarizeCollection(testRange);
        assertEquals("1-3, 6, 9", result);


    }
}
