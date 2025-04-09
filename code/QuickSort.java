package code;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        // int[] array = { 1, 2, 3, 4, 5, 6 };
        // quickSort(array, 0, array.length - 1);
        // for (int i : array) {
        // System.out.println(i + " ");
        // }
        // runStressTest();
        String[] strArray = { "3", "6", "7", "10" };
        System.out.println(kthLargestNumber(strArray, 4));
    }

    public static void quickSort(int[] array, int left, int right) {
        if (left >= right)
            return;
        int pivotIndex = partinationImprove(array, left, right);
        quickSort(array, left, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, right);
    }

    public static void swap(int[] array, int index1, int index2) {
        String a = "B";
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

    public static int partination(int[] array, int indexPivot) {
        int pivotValue = array[indexPivot];
        int i = -1;
        for (int j = 0; j < indexPivot; j++) {
            if (array[j] <= pivotValue) {
                swap(array, ++i, j);
            }
        }
        swap(array, ++i, indexPivot);
        return i;
    }

    public static int partinationImprove(int[] array, int left, int right) {
        int pivotValue = array[right];
        int leftKey = left - 1;
        for (int i = left; i < right; i++) {
            if (array[i] <= pivotValue) {
                swap(array, i, ++leftKey);
            }
        }
        swap(array, ++leftKey, right);
        return leftKey;
    }

    public static void runStressTest() {
        Random random = new Random();
        int testCount = 0;

        while (true) {
            testCount++;

            // Generate a random array
            int[] array = generateRandomArray(random);

            // Expected output using Java’s built-in sort
            int[] expected = array.clone();
            Arrays.sort(expected);

            // Clone and apply QuickSort
            int[] arrayToTest = array.clone();
            quickSort(arrayToTest, 0, arrayToTest.length - 1);

            // Compare results
            if (!Arrays.equals(arrayToTest, expected)) {
                System.out.printf("Test %d failed!%n", testCount);
                System.out.printf("Original: %s%n", Arrays.toString(array));
                System.out.printf("Expected: %s%n", Arrays.toString(expected));
                System.out.printf("Actual:   %s%n", Arrays.toString(arrayToTest));
                break;
            } else {
                System.out.printf("Test %d passed.%n", testCount);
            }
        }
    }

    // Generates a random array of size 1 to 50 with values -100 to 100
    private static int[] generateRandomArray(Random random) {
        int size = random.nextInt(50) + 1;
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(200) - 100;
        }
        return array;
    }

    public static String kthLargestNumber(String[] nums, int k) {
        int p = partination(nums, 0, nums.length - 1);
        int resultIndex = nums.length - k;
        while (p != resultIndex) {
            if (p > resultIndex) {
                p = partination(nums, 0, p - 1);
            }
            if (p < resultIndex) {
                p = partination(nums, p, nums.length - 1);
            }
        }
        return nums[p];
    }

    public static int partination(String[] nums, int left, int right) {
        String pivotValue = nums[right];
        int leftKey = left - 1;
        for (int i = left; i < right; i++) {
            if (nums[i].compareTo(pivotValue) > 0 || nums[i].compareTo(pivotValue) == 0) {
                swap(nums, i, ++leftKey);
            }
        }
        swap(nums, right, ++leftKey);
        return leftKey;
    }

    public static void swap(String[] array, int index1, int index2) {
        String tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

}
