package arrayAndHashmaps;

import java.util.*;
import java.util.stream.Collectors;

/*
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
You must write an algorithm that runs in O(n) time.
 */
public class LongestConsecutiveSequence {

    public static void main(String[] args){
        System.out.println(LongestConsecutiveSequence(new int[]{1,2,3,200,40,41,39,42,38}));
    }

    //the time complexity of the method is O(n), and the space complexity is O(n).
    public static List<Integer> LongestConsecutiveSequence(int[] input) {
        // Check if the input array is empty or has only one element
        if (input == null || input.length == 0) {
            // Return an empty list if the array is empty
            return new ArrayList<>();
        }
        if (input.length == 1) {
            // Return a list with the single element if the array has only one element
            return List.of(input[0]);
        }

        // Create a set from the input array for faster lookup
        Set<Integer> tempset = Arrays.stream(input).boxed().collect(Collectors.toSet());
        // Initialize an empty list to store the longest consecutive sequence found so far
        List<Integer> finalOut = new ArrayList<>();

        // Iterate over the input array
        for (int value : input) {
            int k = value;
            // If k-1 is not in the set, k is the first element of a consecutive sequence
            if (!tempset.contains(k - 1)) {
                // Initialize a counter variable to keep track of the length of the sequence
                int count = 1;
                // Iterate over the set to find the consecutive sequence starting from k
                while (tempset.contains(k + 1)) {
                    k++;
                    count++;
                }
                // If the current sequence is longer than the previous longest sequence, update finalOut
                if (finalOut.size() < count) {
                    // Clear finalOut and add the elements of the current sequence to it
                    finalOut.clear();
                    for (int j = value; j <= k; j++) {
                        finalOut.add(j);
                    }
                }
            }
        }
        // Return the longest consecutive sequence found
        return finalOut;
    }

}
