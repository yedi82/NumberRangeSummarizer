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
        if (!input.isEmpty()) {

            //Creating a list to store the ranges
            List<String> ranges = new ArrayList<>();
            //Creating a list to store the numbers
            List<Integer> numbers = new ArrayList<>(input);
            //Creating a string to store the range
            String range = "";
            //Creating a string to store the result
            String result = "";

            //Iterating through the numbers
            for (int i = 0; i < numbers.size(); i++) {
                //Checking if the range is empty
                if (range.isEmpty()) {
                    //Adding the number to the range
                    range += numbers.get(i);
                }
                //Checking if the range is not empty
                if (!range.isEmpty()) {
                    //Checking if the next number is sequential
                    if (i + 1 < numbers.size()) {
                        if (numbers.get(i + 1) - numbers.get(i) == 1) {
                            //Checking if the range is not empty
                            if (!range.contains("-")) {
                                //Adding the hyphen to the range
                                range += "-";
                            }
                        }
                    } else {
                        //Checking if the range is not empty
                        if (range.contains("-")) {
                            //Adding the number to the range
                            range += numbers.get(i);
                        }
                    }
                }
                //Checking if the range is not empty
                if (!range.isEmpty()) {
                    //Adding the range to the ranges
                    ranges.add(range);
                    //Clearing the range
                    range = "";
                }
            }

            //Iterating through the ranges
            for (int i = 0; i < ranges.size(); i++) {
                //Checking if the range is not empty
                if (!ranges.get(i).contains("-")) {
                    //Adding the range to the result
                    result += ranges.get(i);
                } else {
                    //Splitting the range by hyphen
                    String[] rangeParts = ranges.get(i).split("-");
                    //Adding the range to the result
                    result += rangeParts[0] + "-" + rangeParts[1];
                }
                //Checking if the next range is not empty
                if (i + 1 < ranges.size()) {
                    //Adding the comma to the result
                    result += ", ";
                }
            }

            return result;
        }

        return "";
    }

}
