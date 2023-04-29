package arrayAndHashmaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.
https://leetcode.com/problems/two-sum/
*/
public class FindPairsThatAddUpToSum {

    public static void main(String[] args) {
        FindPairsThatAddUpToSum findPairsThatAddUpToSum = new FindPairsThatAddUpToSum();
        System.out.println("Hello world!");
        System.out.println(findPairsThatAddUpToSum.findPairsThatAddUpToSum(List.of(1,2,3,4), 3));
    }

    public List<Integer> findPairsThatAddUpToSum(List<Integer> input, int sum) {

        Map<Integer, Integer> indexByValue = new HashMap<>();

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < input.size(); i++) {
            int currentValue = input.get(i);
            int complementValue = sum - currentValue;

            Integer complementIndex = indexByValue.get(complementValue);

            if (complementIndex != null) {
                result.add(complementValue);
                result.add(currentValue);
            }
            indexByValue.put(currentValue, i);
        }
        return result;
    }
}
