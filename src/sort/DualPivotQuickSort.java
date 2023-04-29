package sort;

/*
https://www.youtube.com/watch?v=r3a25XPf2A8
 */
public class DualPivotQuickSort {

    // Driver code
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 0, 24, 8, 42, 75, 29, 77, 38, 57, 111};

        dualPivotQuickSort(arr, 0, 7);

        System.out.print("So sorted array: ");
        for (int i = 0; i < 8; i++)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    // Java program to implement dual pivot QuickSort
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static void dualPivotQuickSort(int[] arr, int low, int high) {
        if (low < high) {

            // piv[] stores left pivot and right pivot.
            // piv[0] means left pivot and
            // piv[1] means right pivot
            int[] piv;
            piv = partition(arr, low, high);

            dualPivotQuickSort(arr, low, piv[0] - 1);
            dualPivotQuickSort(arr, piv[0] + 1, piv[1] - 1);
            dualPivotQuickSort(arr, piv[1] + 1, high);
        }
    }

    static int[] partition(int[] arr, int low, int high) {
        if (arr[low] > arr[high])
            swap(arr, low, high);

        // p is the left pivot, and q is the right pivot.
        int j = low + 1;
        int g = high - 1;
        int k = low + 1;
        int p = arr[low];
        int q = arr[high];

        while (k <= g) {

            // If elements are less than the left pivot
            if (arr[k] < p) {
                swap(arr, k, j);
                j++;
            }

            // If elements are greater than or equal to the right pivot
            else if (arr[k] >= q) {
                while (arr[g] > q && k < g)
                    g--;

                swap(arr, k, g);
                g--;

                if (arr[k] < p) {
                    swap(arr, k, j);
                    j++;
                }
            }
            k++;
        }
        j--;
        g++;

        // Bring pivots to their appropriate positions.
        swap(arr, low, j);
        swap(arr, high, g);

        // Returning the indices of the pivots because we cannot return two elements
        // from a function, we do that using an array.
        return new int[]{j, g};
    }


}