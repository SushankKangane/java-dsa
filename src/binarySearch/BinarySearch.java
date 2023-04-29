package binarySearch;

/*
Given an array of integers nums which is sorted in ascending order,
and an integer target, write a function to search target in nums.
If target exists, then return its index. Otherwise, return -1.
You must write an algorithm with O(log n) runtime complexity.
https://leetcode.com/problems/binary-search/
 */
public class BinarySearch {
    public static void main(String[] args) {

        binarySearch(new int[]{1,2,4,7,8,90,100}, 8);

    }

    /*
    This is a Java implementation of the binary search algorithm.
    It takes an array of integers nums and a target integer target as input
    and returns the index of the target if it exists in the array, and -1 otherwise.
    The algorithm works by repeatedly dividing the search interval in half until the target is found
    or determined to be not present in the array.
     */
    public static int binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

}
