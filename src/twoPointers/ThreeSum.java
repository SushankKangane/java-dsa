package twoPointers;

import java.util.*;
import java.util.stream.IntStream;

public class ThreeSum {

    public static void main(String[] args){
        //TODO
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>(); // to store the resulting triplets
        Arrays.sort(nums); // sort the input array in non-decreasing order
        for (int i = 0; i < nums.length - 2; i++) { // iterate over all possible first elements

            if (i > 0 && nums[i] == nums[i - 1]) continue; // skip duplicate values for the first element

            int target = -nums[i]; // set the target value to the negative of the current element
            int left = i + 1; // set the left pointer to the next element after the current element
            int right = nums.length - 1; // set the right pointer to the last element in the array
            while (left < right) { // iterate until the left and right pointers meet
                int sum = nums[left] + nums[right]; // calculate the sum of the current left and right pointers
                if (sum == target) { // if the sum equals the target value, we found a triplet
                    result.add(Arrays.asList(nums[i], nums[left], nums[right])); // add the triplet to the result list
                    while (left < right && nums[left] == nums[left + 1]) left++; // skip duplicate values for the left pointer
                    while (left < right && nums[right] == nums[right - 1]) right--; // skip duplicate values for the right pointer
                    left++; // move the left pointer to the next distinct value
                    right--; // move the right pointer to the next distinct value
                } else if (sum < target) { // if the sum is less than the target value, move the left pointer to the right
                    left++;
                } else { // if the sum is greater than the target value, move the right pointer to the left
                    right--;
                }
            }
        }
        return result; // return the resulting list of triplets
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>(); // to store the frequency of each element
        for (int num : nums) { // count the frequency of each element
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] distinctNums = map.keySet().stream().mapToInt(Integer::intValue).toArray(); // get the distinct elements in the array
        Arrays.sort(distinctNums); // sort the distinct elements in non-decreasing order
        for (int i = 0; i < distinctNums.length - 2; i++) { // iterate over all possible first elements
            int num1 = distinctNums[i];
            if (num1 > 0) break; // break if the first element is greater than 0
            if (num1 == 0 && map.get(num1) >= 3) { // handle the special case when the first element is 0
                result.add(Arrays.asList(0, 0, 0));
                continue;
            }
            for (int j = i + (num1 == 0 ? 1 : 0); j < distinctNums.length - 1; j++) { // iterate over all possible second elements
                int num2 = distinctNums[j];
                if (num1 + num2 > 0) break; // break if the sum of the first and second element is greater than 0
                if (num1 + num2 == 0 && map.get(num2) >= 2) { // handle the special case when the sum of the first and second element is 0
                    result.add(Arrays.asList(num1, num2, num2));
                    continue;
                }
                int num3 = -num1 - num2; // calculate the third element
                if (num3 <= num2) break; // break if the third element is less than or equal to the second element
                if (map.containsKey(num3)) { // check if the third element exists in the map
                    result.add(Arrays.asList(num1, num2, num3));
                }
            }
        }
        return result;
    }


}
