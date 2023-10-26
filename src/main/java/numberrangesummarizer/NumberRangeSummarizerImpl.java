package numberrangesummarizer;

import java.util.*;

// This class implements the NumberRangeSummarizer
public class NumberRangeSummarizerImpl implements NumberRangeSummarizer {

    /**
     * This method converts a String list of numbers separated by commas to a Collection of integers.
     *
     * @param input A String list of numbers separated by commas.
     * @return A Collection of integers.
     */
    @Override
    public Collection<Integer> collect(String input) {

        // The numbers in the String are split into an array using the delimiter "," followed by zero or more spaces.
        String[] splitNumberList = input.split(",\\s*");

        // A new HashSet is declared - this will help get rid of duplicates.
        Collection<Integer> numbersList = new HashSet<>();

        // An enhanced for loop iterates through the String array, converts them into integers
        // and adds them to the ArrayList.
        for (String stringInteger : splitNumberList) {

            // This try-catch block makes sure that the String being parsed is a valid integer, otherwise it ignores it.
            try{

                int convertedNumber = Integer.parseInt(stringInteger);
                numbersList.add(convertedNumber);

            } catch (NumberFormatException e){
                // If the catch block runs, the convertedNumber is not a valid integer and it gets ignored.
            }
        }

        // Return the Collection of integers
        return numbersList;

    }

    /**
     * This method summarizes a Collection of integers by grouping sequential numbers into ranges.
     *
     * @param input A collection of integers to be summarized.
     * @return A comma-delimited string containing summarized number ranges.
     */
    @Override
    public String summarizeCollection(Collection<Integer> input) {

        // Checks if the collection is empty. If true, it returns an empty string.
        if(input.isEmpty()){
            return "";
        }

        // Create a List from the input Collection to allow indexed access.
        List<Integer> integerList = new ArrayList<>(input);
        // Makes sure the list is sorted.
        Collections.sort(integerList);

        // Declare a StringBuilder to store all the ranges.
        StringBuilder ranges = new StringBuilder(); // Using a StringBuilder is more efficient than using an ArrayList.

        // Initialize two integers to keep track of the start and end of a range.
        // Both 'startRange' and 'endRange' are initially set to the first element of 'integerList'.
        // This approach is more efficient than declaring an ArrayList and clearing it in each iteration of the loop.
        int startRange = integerList.get(0);
        int endRange = integerList.get(0);

        // A for loop iterates over the integerList, starting from the second element.
        for(int i = 1; i < integerList.size(); i++){

            // Check if the current number is one greater than the previous number.
            if(integerList.get(i) == integerList.get(i - 1) + 1){
                // Update 'endRange' to store the current element of the ArrayList.
                endRange = integerList.get(i);
            } else {
                // Check if the startRange integer is less than the endRange integer.
                if(startRange < endRange){
                    // Append the startRange and endRange integers to ranges, separated by a dash ('-').
                    ranges.append(startRange + "-" + endRange);
                } else {
                    // Add the current element to ranges.
                    ranges.append(integerList.get(i - 1));
                }
                // As the current element is not sequential from the previous number, a ", " is appended to ranges.
                ranges.append(", ");
                // The startRange is updated to the current integer.
                startRange = integerList.get(i);
            }
        }

        // As the above for loop will not be able to check the final element in the integerList,
        // a final if statement will check if the startRange integer is less than the endRange integer.
        if(startRange < endRange){
            // Append the startRange and endRange integers to ranges, separated by a dash ('-').
            ranges.append(startRange + "-" + endRange);
        } else {
            // Add the final element to ranges.
            ranges.append(integerList.get(integerList.size() -1));
        }

        // The List of strings in ranges is joined into one String with the delimiter ", ".
        return ranges.toString();
    }

}
