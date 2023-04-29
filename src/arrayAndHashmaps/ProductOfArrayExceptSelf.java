package arrayAndHashmaps;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        Arrays.stream(Arrays.stream(productExceptSelf(new int[]{1, 3, 5, 2})).toArray()).sequential().forEach(
                System.out::println
        );
    }


    /*
    The time complexity of the code is O(N)
    The space complexity of the code is O(N)
    */
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Compute product of all elements to the left of current element
        int leftProduct = 1;
        for (int i = 0; i < n; i++) {
            result[i] = leftProduct;
            leftProduct *= nums[i];
        }

        // Compute product of all elements to the right of current element
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        return result;
    }
}
