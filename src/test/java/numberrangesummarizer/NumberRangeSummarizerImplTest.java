package numberrangesummarizer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberRangeSummarizerImplTest {
    private NumberRangeSummarizerImpl summarizer;
    private Collection<Integer> testRange;

    // This method is executed before each test to set up common test data.
    @BeforeEach
    public void setUp(){
        summarizer = new NumberRangeSummarizerImpl();
        testRange = new ArrayList<>();
    }

    // This test case checks the collect() method to ensure it correctly converts a string of numbers into
    // a collection of integers.
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
