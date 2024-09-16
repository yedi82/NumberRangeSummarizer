package numberrangesummarizer;

import java.util.*;

public class NumberRangeSummarizerImpl implements NumberRangeSummarizer {

    @Override
    public Collection<Integer> collect(String input) {
        //Creating an List which will contain/consists of all the numbers
        List<Integer> nums = new ArrayList<>();

        //Splitting the input string by comma
        String[] numStrings = input.split(",");

        //Iterating through the splitted strings
        for (String numStr : numStrings) {
            //Parsing the string to an integer
            int number = Integer.parseInt(numStr.trim());
            //Adding the integer to the list
            nums.add(number);
        }

        //Ordering in Numerical using the collections class
        Collections.sort(nums);

        return nums;
    }

    @Override
    public String summarizeCollection(Collection<Integer> input) {
        if (input.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        List<Integer> sortedNumbers = new ArrayList<>(input);
        int rangeStart = sortedNumbers.get(0);
        int previous = rangeStart;

        for (int i = 1; i < sortedNumbers.size(); i++) {
            int current = sortedNumbers.get(i);

            if (current != previous + 1) {
                // Close current range and start a new one
                if (rangeStart == previous) {
                    result.append(rangeStart);
                } else {
                    result.append(rangeStart).append("-").append(previous);
                }
                result.append(", ");
                rangeStart = current;
            }

            previous = current;
        }

        // Append the final range
        if (rangeStart == previous) {
            result.append(rangeStart);
        } else {
            result.append(rangeStart).append("-").append(previous);
        }

        return result.toString();
    }

}
