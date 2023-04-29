package slidingWindow;

import java.util.Arrays;
import java.util.HashMap;

public class PermutationString {

    public static void main(String[] args){

        int[] k = {1,2};
        int[] j = {1,2};
        System.out.println(Arrays.equals(k,j));


         String s1 = "abcajja";
        System.out.println(permutationString("abc",s1));

        int[] arr = new int[26];
        //add the values to the hash array
        for (int i = 0; i < s1.length(); i++) {
            System.out.println(s1.charAt(i) - 'a');
            arr[s1.charAt(i) - 'a']++;
        }
        System.out.println(Arrays.stream(arr).boxed().toList());
    }

    public static boolean permutationString(String s1, String s2){
        int[] arr = new int[26];
        int[] arr2 = new int[26];
        //add the values to the hash array
        for (int i = 0; i < s1.length(); i++) {
            System.out.println(s1.charAt(i) - 'a');
            arr[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            System.out.println(s2.charAt(i) - 'a');
            arr2[s2.charAt(i) - 'a']++;
        }
        int matches = 0;
        for (int i = 0; i < 26 ; i++){
            if (arr2[i] == arr[i]){
                matches++;
            }
        }

        //TODO


        for (int i = 1 ; i < s2.length(); i++){
            int j = s2.charAt(i-1) - 'a';
            arr2[j]--;
            if (arr2[j] != arr[j]){
                matches --;
            }
            if (matches == 26){return true;};
        }
        return false;
    }
    public static void set(String in){
        HashMap<Character,  Integer> set = new HashMap<>(){};
        /*for (char i : in.toCharArray()){
            set.put(i, 1);
            if ()
        }*/

    }


}
