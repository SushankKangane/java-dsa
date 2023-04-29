package arrayAndHashmaps;

import java.util.*;

public class TopKFrequent {

    public static void main(String[] args){
        System.out.println();
        System.out.println(Arrays.toString(topKFrequent(List.of(1, 2, 2, 4, 10, 1), 2)));
    }

    public static int[] topKFrequent(List<Integer> nums, int k){

        // Step 1: Create a hashmap to store the frequency of each element
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create a priority queue and add the entries of the hashmap to it
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // Step 3: Create the result array and populate it with the top k elements
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = pq.poll().getKey();
        }
        return result;
    }
}
