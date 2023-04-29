package twoPointers;

/*
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters
and removing all non-alphanumeric characters,
it reads the same forward and backward. Alphanumeric characters include letters and numbers.
Given a string s, return true if it is a palindrome, or false otherwise.
https://leetcode.com/problems/valid-palindrome/
*/

public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isValidPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isValidPalindrome("race a car"));
    }


    /**
     * Determines whether a given string is a valid palindrome after converting all uppercase
     * letters to lowercase letters and removing all non-alphanumeric characters.
     *
     * @param input the input string to check for palindrome
     * @return true if the input string is a valid palindrome, false otherwise
     */
    public static boolean isValidPalindrome(String input) {
        // Remove all non-alphanumeric characters and convert to lowercase
        String cleanedInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Get the length of the cleaned input
        int length = cleanedInput.length();

        // Iterate through the string up to its halfway point
        for (int i = 0; i < length / 2; i++) {
            // Check if the characters at opposite ends of the string match
            if (cleanedInput.charAt(i) != cleanedInput.charAt(length - 1 - i)) {
                // If not, return false immediately as it is not a palindrome
                return false;
            }
        }
        // If all characters match up to the halfway point, it is a valid palindrome
        return true;
    }

}
