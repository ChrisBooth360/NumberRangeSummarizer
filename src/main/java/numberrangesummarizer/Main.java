package numberrangesummarizer;

import java.util.Collection;

public class Main {
    public static void main(String[] args) {

        // Initialize a String of numbers separated by commas.
        String sampleInput = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";

        // Create an instance of the NumberRangeSummarizerImpl class.
        NumberRangeSummarizerImpl example = new NumberRangeSummarizerImpl();

        // Generate a Collection of integers from the sampleInput using the collect() method.
        Collection<Integer> integerCollection = example.collect(sampleInput);
        System.out.println("Input Collection: " + integerCollection);

        // Summarize the Collection using the summarizeCollection() method to produce a comma-delimited list
        // with sequential numbers grouped, and store it in the 'result' variable.
        String result = example.summarizeCollection(integerCollection);
        System.out.println("Summarized Result: " + result);

    }
}