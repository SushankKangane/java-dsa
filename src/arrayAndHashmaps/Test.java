package arrayAndHashmaps;

import java.util.*;

public class Test {

    public static void main(String[] args){
        findAllZeroSumSubarrays(new int[]{1, 2, -1, 3, 0, 1, -3, -4, 1}).forEach(
                i ->{
                    for (int j : i) {
                        System.out.print(j + " ");
                    }
                    System.out.println();
                }
        );

        //System.out.println(findAllSubarrays(new int[]{1, 2, -1, 3, 0, 1, -3, -4, 1}));

    }
    //O(n)
    public static List<int[]> findAllZeroSumSubarrays(int[] arr) {
        List<int[]> subarrays = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(0, new ArrayList<>(Arrays.asList(-1)));
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum)) {
                List<Integer> indices = map.get(sum);
                for (int index : indices) {
                    int[] subarray = Arrays.copyOfRange(arr, index+1, i+1);
                    subarrays.add(subarray);
                }
                indices.add(i);
            } else {
                map.put(sum, new ArrayList<>(Arrays.asList(i)));
            }
        }
        return subarrays;
    }



}
