package slidingWindow;

import java.util.ArrayList;
import java.util.List;

/*
Given a string s, find the length of the longest substring without repeating characters.
https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstring {

    public static void main(String[] args) {
        System.out.println(longestString("sushabcabcaaaabcc"));
    }


    //This implementation has a time complexity of O(n) and a space complexity of O(1)
    public static int longestString(String s) {

        List<Character> substringL = new ArrayList<>();

        int largestlength = 0;

        for (int right = 0; right < s.length(); right++) {
            if (substringL.contains(s.charAt(right))) {
                // get the index of the char
                int index = substringL.indexOf(s.charAt(right));
                substringL.remove(index);
                if (index > 0)
                    substringL.subList(0, index).clear();
            }
            substringL.add(s.charAt(right));
            largestlength = Math.max(largestlength, substringL.size());
        }
        return largestlength;
    }
}
