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
        while (numStrings.length > 0) {
            //Parsing the string to integer
            int num = Integer.parseInt(numStrings[0]);
            //Adding the integer to the list
            nums.add(num);
            //Removing the first element from the array
            numStrings = Arrays.copyOfRange(numStrings, 1, numStrings.length);
        }

        //Ordering the list, making use of the collections cla
        //Numerical order sorting from (1,....)
        Collections.sort(nums);

        return nums;
    }

    @Override

    public String summarizeCollection(Collection<Integer> input) {

        return null;
    }

}
