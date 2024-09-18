package numberrangesummarizer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * This class will implement the NumberRangeSummarizer interface to produce a
 * comma delimited list of numbers, grouping the numbers into a range when they
 * are sequential.
 *
 * Sample Input: "1,3,6,7,8,12,13,14,15,21,22,23,24,31 Result: "1, 3, 6-8,
 * 12-15, 21-24, 31"
 */
public class NumberRangeSummarizerImpl implements NumberRangeSummarizer {

    /**
     * This method will collect the numbers from the input string
     *
     * @param input
     * @return Collection<Integer>
     */
    @Override
    public Collection<Integer> collect(String input) {
        //Creating an List which will contain/consists of all the numbers
        List<Integer> nums = new ArrayList<>();

        //Splitting the input string by comma
        String[] numStrings = input.split(",");

        //Iterating through the splitted strings
        for (String numStr : numStrings) {
            //Parsing string to integer
            int number = Integer.parseInt(numStr.trim());
            //Adding to list
            nums.add(number);
        }

        //Order Numerically
        Collections.sort(nums);

        return nums;
    }

    /**
     * This method will summarize the collection of numbers
     *
     * @param input
     * @return String
     */
    @Override
    public String summarizeCollection(Collection<Integer> input) {

        //Checking if the input is not empty
        if (!input.isEmpty()) {

            //Store the summarized numbers in StringBuilder 
            StringBuilder sumNum = new StringBuilder();

            //List to store the sorted numbers
            List<Integer> sortedNumbers = new ArrayList<>(input);

            //Stores the start of the range
            int rangeStart = sortedNumbers.get(0);

            //stores the previous number
            int previous = rangeStart;

            for (int i = 1; i < sortedNumbers.size(); i++) {
                int current = sortedNumbers.get(i);

                if (current != previous + 1) {
                    //Close current range and start a new one
                    /*If the rangeStart is equal to the previous number, 
                    then append the rangeStart to the StringBuilder
                    else append the rangeStart and the previous number to the StringBuilder
                     */
                    if (rangeStart == previous) {
                        sumNum.append(rangeStart);
                    } else {
                        sumNum.append(rangeStart).append("-").append(previous);
                    }
                    sumNum.append(", ");
                    rangeStart = current;
                }

                previous = current;
            }

            //Append the final range
            if (rangeStart == previous) {
                /**
                 * If the rangeStart is equal to the previous number, then
                 * append the rangeStart
                 */
                sumNum.append(rangeStart);
            } else {
                sumNum.append(rangeStart).append("-").append(previous);
            }

            return sumNum.toString();
        }
        return "";

    }

}
