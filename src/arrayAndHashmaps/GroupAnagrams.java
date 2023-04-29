package arrayAndHashmaps;

import java.util.*;

/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
typically using all the original letters exactly once.
https://leetcode.com/problems/group-anagrams/
 */
public class GroupAnagrams {

    public static void main(String[] args){
        //test();


        System.out.println(groupAnagrams(List.of("zbc", "zby", "bzc")));
    }

    public static void test(){
        String word = "abky";
        int[] counts = new int[26];
        for (char c : word.toCharArray()) {
            System.out.println("c: " + c);
            System.out.println(counts[c - 'a']++);
            counts[c - 'a']++;
        }
    }


    public static List<List<String>> groupAnagrams(List<String> strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String word : strs) {
            int[] counts = new int[26];
            for (char c : word.toCharArray()) {
                System.out.println("ss " + c);
                System.out.println("what is this "+ (c - 'a'));
                counts[c - 'a']++;
                System.out.println(Arrays.toString(Arrays.stream(counts).toArray()));
            }
            StringBuilder sb = new StringBuilder();
            for (int count : counts) {
                sb.append(count);
            }
            String key = sb.toString();
            if (groups.containsKey(key)) {
                groups.get(key).add(word);
            } else {
                List<String> anagrams = new ArrayList<>();
                anagrams.add(word);
                groups.put(key, anagrams);
            }
        }
        return new ArrayList<>(groups.values());
    }
}
