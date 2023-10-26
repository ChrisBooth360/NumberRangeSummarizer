package numberrangesummarizer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

        // A new ArrayList is declared.
        Collection<Integer> numbersList = new ArrayList<>();

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
        // Create a List from the input Collection to allow indexed access.
        List<Integer> integerList = new ArrayList<>(input);

        // Initialize two Lists, one to store all the ranges and one to store the current range that will
        // track sequential numbers.
        List<String> ranges = new ArrayList<>();
        List<Integer> currentRange = new ArrayList<>();

        // Initialize the currentRange with the first integer in the List.
        currentRange.add(integerList.get(0));

        // A for loop iterates over the integerList, starting from the second element.
        for(int i = 1; i < integerList.size(); i++){

            // Check if the current number is one greater than the previous number.
            if(integerList.get(i) == integerList.get(i - 1) + 1){
                // Add the current number to the currentRange.
                currentRange.add(integerList.get(i));
            } else {
                // Check if the length of the currentRange is greater than 1.
                if(currentRange.size() > 1){
                    // Add the first and last numbers of currentRange to ranges, separated by a dash ('-').
                    ranges.add(currentRange.get(0) + "-" + currentRange.get(currentRange.size() - 1));
                } else {
                    // Add the first number of currentRange to ranges.
                    ranges.add(currentRange.get(0).toString());
                }

                // As the current number is not sequential from the previous number, the currentRange is cleared
                // and the current number added to currentRange.
                currentRange.clear();
                currentRange.add(integerList.get(i));
            }
        }

        // As the above for loop will not be able to check the final number in the integerList,
        // a final if statement will check if the currentRange length is greater than 1.
        if(currentRange.size() > 1){
            // Add the first and last numbers of currentRange to ranges, separated by a dash ('-').
            ranges.add(currentRange.get(0) + "-" + currentRange.get(currentRange.size() - 1));
        } else {
            // Add the first number of currentRange to ranges.
            ranges.add(currentRange.get(0).toString());
        }

        // The List of strings in ranges is joined into one String with the delimiter ", ".
        return String.join(", ", ranges);
    }
}
