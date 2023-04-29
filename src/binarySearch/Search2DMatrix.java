package binarySearch;

import java.util.Arrays;
import java.util.List;

public class Search2DMatrix {

    public static void main(String[] args){

        System.out.println(search2DMatrix(new int[][]  {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 5));
    }


    public static int binarySearch(int[] nums, int target) {
        List<Integer> list = Arrays.stream(nums).boxed().toList();
        System.out.println(list);

        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid =  (high - low) / 2;
            System.out.println("mid , low, high " + mid + " " + low + " " + high);
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
    public static int search2DMatrix(int[][] matrix, int target){

        int m = matrix.length;
        int n = matrix[0].length;

        int high = 0;
        int low = m -1;

        while (high < low){
            int mid = (low-high)/2;
            System.out.println("matrix[mid][0]" + matrix[mid][0] + " matrix[mid][n-1] "+ matrix[mid][n-1]);
            if (matrix[mid][0] <= target || target <= matrix[mid][n-1] ){
                int ans =  binarySearch(matrix[mid], target);
                System.out.println("ans "    + ans);
                System.out.println("mid " + mid);
                return ans + mid;

            }
            else if (target< matrix[mid][0]){
                low = mid -1;
            }
            else high = mid +1;
        }
        return 0;
    }


    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int i = mid / n;
            int j = mid % n;

            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

}
