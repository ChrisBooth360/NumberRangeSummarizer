package numberrangesummarizer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberRangeSummarizerImplTest {

    // Declare variables used in the test cases.
    private NumberRangeSummarizerImpl summarizer;
    private Collection<Integer> testRange;

    // This method is executed before each test to set up common test data.
    @BeforeEach
    public void setUp(){
        summarizer = new NumberRangeSummarizerImpl();
        testRange = new HashSet<>();
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

    // Ensures the collect() method does not return a Collection with duplicates.
    @Test
    public void testCollectDuplicates(){

        // A Collection with no duplicates is created.
        testRange.add(1);
        testRange.add(2);

        // A String is parsed with duplicate numbers.
        Collection<Integer> result = summarizer.collect("1,1,2");

        assertEquals(testRange, result);
    }

    /**
     The following unit tests ensure the collect() method can handle various test cases.
     */
    // Ensures the summarizeCollection() method correctly summarizes a Collection of integers that contain ranges
    // and single integers.
    @Test
    public void testSummarizeCollectionRangesAndSingleIntegers(){

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

    // Ensures the summarizeCollection() can summarize a range at the end of a Collection.
    @Test
    public void testSummarizeCollectionRangeAtEnd(){

        testRange.add(1);
        testRange.add(3);
        testRange.add(7);
        testRange.add(8);
        testRange.add(9);

        String result = summarizer.summarizeCollection(testRange);
        assertEquals("1, 3, 7-9", result);

    }

    // Ensures the summarizeCollection() can summarize a Collection of only ranges.
    @Test
    public void testSummarizeCollectionOnlyRanges(){

        testRange.add(1);
        testRange.add(2);
        testRange.add(5);
        testRange.add(6);
        testRange.add(7);

        String result = summarizer.summarizeCollection(testRange);
        assertEquals("1-2, 5-7", result);

    }

    // Ensures the summarizeCollection() can 'summarize' a Collection of only non-sequential numbers.
    @Test
    public void testSummarizeCollectionNoSequentialIntegers(){

        testRange.add(0);
        testRange.add(3);
        testRange.add(5);
        testRange.add(7);

        String result = summarizer.summarizeCollection(testRange);
        assertEquals("0, 3, 5, 7", result);

    }

    // Ensures the summarizeCollection() method can 'summarize' a single integer.
    @Test
    public void testSummarizeCollectionSingleInteger(){

        testRange.add(1);

        String result = summarizer.summarizeCollection(testRange);
        assertEquals("1", result);

    }

    // Ensures the summarizeCollection() method can handle negative integers.
    @Test
    public void testSummarizeCollectionNegativeIntegers(){
        testRange.add(-1);
        testRange.add(0);
        testRange.add(1);
        testRange.add(3);

        String result = summarizer.summarizeCollection(testRange);
        assertEquals("-1-1, 3", result);
    }

    // Ensures the summarizeCollection() method returns an empty String if the Collection is empty.
    @Test
    public void testSummarizeCollectionEmptyInput(){
        String result = summarizer.summarizeCollection(testRange);
        assertEquals("", result);
    }

    // Ensures the summarizeCollection() can take an unordered Collection and return an ordered summarized range.
    @Test
    public void testSummarizeCollectionNotInOrder(){
        testRange.add(2);
        testRange.add(1);
        testRange.add(6);
        testRange.add(3);

        String result = summarizer.summarizeCollection(testRange);

        assertEquals("1-3, 6", result);

    }

}
