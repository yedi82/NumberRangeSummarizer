package numberrangesummarizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class NumberRangeSummarizerTester {

    //////////////////Test cases//////////////////

    //Test case 1 - collect
    /**
     * This test case will test the collect method of the NumberRangeSummarizerImpl class
     * by passing a string of numbers and checking if the numbers are collected correctly.
     */
    @Test
    public void testCollect() {
        NumberRangeSummarizer summarizer = new NumberRangeSummarizerImpl();
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        Collection<Integer> collected = summarizer.collect(input);

        //Expected list of numbers
        List<Integer> expected = Arrays.asList(1, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31);
        assertEquals(expected, new ArrayList<>(collected));
    }

    //Test case 2 - summarizeCollection
    /**
     * This test case will test the summarizeCollection method of the
     * NumberRangeSummarizerImpl class by passing a collection of numbers and
     * checking if the numbers are summarized correctly.
     */
    @Test
    public void testSummarizeCollection() {
        NumberRangeSummarizer summarizer = new NumberRangeSummarizerImpl();
        List<Integer> input = Arrays.asList(1, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31);

        //Expected result
        String result = summarizer.summarizeCollection(input);
        assertEquals("1, 3, 6-8, 12-15, 21-24, 31", result);
    }

    //////////////////Additional test cases//////////////////

    //Test case 3 - empty input
    /**
     * This test case will test the summarizeCollection method of the
     * NumberRangeSummarizerImpl class by passing an empty list of numbers
     * and checking if the result is an empty string.
     */
    @Test
    public void testEmptyInput() {
        NumberRangeSummarizer summarizer = new NumberRangeSummarizerImpl();
        List<Integer> input = Collections.emptyList();
        String result = summarizer.summarizeCollection(input);
        //Expected result is an empty string
        assertEquals("", result);
    }

    //Test case 4 - single number
    /**
     * This test case will test the summarizeCollection method of the
     * NumberRangeSummarizerImpl class by passing a list of a single number and
     * checking if the result is the same number.
     */
    @Test
    public void testSingleNumber() {
        NumberRangeSummarizer summarizer = new NumberRangeSummarizerImpl();
        List<Integer> input = Arrays.asList(7);
        String result = summarizer.summarizeCollection(input);
        //Expected result is the same number
        assertEquals("7", result);
    }

    //Test case 5 - no sequential numbers
    /**
     * This test case will test the summarizeCollection method of the
     * NumberRangeSummarizerImpl class by passing a list of numbers that are not
     * sequential and checking if the result is the same numbers.
     */
    @Test
    public void testNoSequentialNumbers() {
        NumberRangeSummarizer summarizer = new NumberRangeSummarizerImpl();
        List<Integer> input = Arrays.asList(1, 3, 5, 7, 9, 11);
        String result = summarizer.summarizeCollection(input);
        //Expected result is the same numbers
        assertEquals("1, 3, 5, 7, 9, 11", result);
    }

    //Test case 6 - all sequential numbers
    /**
     * This test case will test the summarizeCollection method of the
     * NumberRangeSummarizerImpl class by passing a list of sequential numbers
     * and checking if the result is a range of numbers.
     */
    @Test
    public void testAllSequentialNumbers() {
        NumberRangeSummarizer summarizer = new NumberRangeSummarizerImpl();
        List<Integer> input = Arrays.asList(5, 6, 7, 8, 9);
        String result = summarizer.summarizeCollection(input);
        //Expected result is a range of numbers
        assertEquals("5-9", result);
    }
}
