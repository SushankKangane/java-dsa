package twoPointers;

import java.util.*;
import java.util.stream.Collectors;

/*
Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1]
and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
The tests are generated such that there is exactly one solution. You may not use the same element twice.
Your solution must use only constant extra space
https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class TwoSum {
    public static void main(String[] args){
        System.out.println(twoSum1(new int[]{111,2,3,6,10}, 13));
    }


    //This implementation has a time complexity of O(n), where n is the length of the nums array, and a space complexity of O(n)
    public static List<Integer> twoSum1(int[] input, int target){
        Set<Integer> inputSet = Arrays.stream(input).boxed().collect(Collectors.toSet());
        for (int i = 0; i< input.length; i ++){
            if (input[i] > target){
                continue;
            }
            if (inputSet.contains(target - input[i])){
                for (int j = i+1; j < input.length; j++){
                    if (input[j] == target - input[i]){
                        return List.of(i, j);
                    }
                }
            }
        }
        return null;
    }

    //This implementation has a time complexity of O(n), where n is the length of the nums array, and a space complexity of O(n)
    public static List<Integer> twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return Arrays.asList(map.get(complement), i);
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
