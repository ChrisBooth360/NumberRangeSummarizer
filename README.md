# Number Range Summarizer

This is the README for the Impact take home assessment. Below are the instructions 
and the details on how this task was approached.

## Assessment Instructions:
Implement this Interface to produce a comma delimited list of numbers,
grouping the numbers into a range when they are sequential.

* Sample Input: "1,3,6,7,8,12,13,14,15,21,22,23,24,31"
* Result: "1, 3, 6-8, 12-15, 21-24, 31"

## Solution

### Step 1: Pseudo-code
The first step when looking at this problem and the provided interface, is to write out
the logic in simple language or pseudo-code.

* Split the input string into an array, converting each element to an integer, 
resulting in 'listOfIntegers'.
* Initialize two lists:
  - 'ranges' to store arrays of strings.
  - 'currentRange' to track sequential numbers. 
* Add the first element from 'listOfIntegers' to 'currentRange'.
* Iterate over 'listOfIntegers' starting from the second element:
  - Check if the number is one more than the previous number:
    - If yes, add it to 'currentRange' and move to the next number.
    - If no, check the length of 'currentRange':
      - If it's greater than 1, add the first and last numbers of 'currentRange' to 'ranges'.
      - If it's not, add only the first number of 'currentRange' to 'ranges'.
      - Clear 'currentRange' and add the current number to it.
* After the loop, join all stringified numbers in 'ranges' into a single string 
using the delimiter ", ".
  - This result is a comma-delimited list with sequential numbers grouped.

### Step 2: File Structure

A clean and logical file structure is crucial for effective code organisation.
The solution should contain the following components.

* The provided interface NumberRangeSummarizer.
* **Interface Implementation:** A class that implements the provided interface.
* **Main Class:** A class that contains the main() method to call methods 
in the implemented class.
* **Unit Tests:** A class for unit tests of the solution.

Here is the file structure for this solution:

* src/
  * main/
    * java/
      * numberrangesummarizer/
        * NumberRangeSummarizer.java (interface)
        * NumberRangeSummarizerImpl.java (interface implementation)
        * Main.java (Main Class)
  * test/
    * java/
      * numberrangesummarizer/
        * NumberRangeSummarizerImplTest (Unit Tests)

### Step 3: Writing Test Cases

Following the principles of TDD, the next step is to write a series of unit tests
that will test the methods within the implementation class 
NumberRangerSummarizerImpl. Once the logic is writtern, this will ensure 
that the implemented logic functions correctly and that any future changes 
or updates can be made with confidence in the code's stability.

JUnit is used as the testing framework in this assessment.
You can find the test file in
src/test/numberrangersummarizer/NumberRangerSummarizerImplTest.java

### Step 4: Writing the logic

Now that basic unit tests have been written, the logic can be written in the implementation class
and tested. You can find the logic for the solution in 
src/main/numberrangersummarizer/NumberRangerSummarizerImpl.java



