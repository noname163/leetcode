package code;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {
    public static void main(String[] args) {
        // int[] array = { 4, 2, 1, 5, 3, 9, 6 };
        // solution(array, 0, array.length - 1);
        runStressTest();
    }

    public static int[] solution(int[] array, int left, int right) {
        if (left == right) {
            return array;
        }
        if (left + 1 == right) {
            if (array[left] > array[right]) {
                int tmp = array[left];
                array[left] = array[right];
                array[right] = tmp;
            }
            return array;
        } else {
            int middle = (left + right) / 2;
            solution(array, left, middle);
            solution(array, middle + 1, right);
            merge(array, left, right, middle);
            return array;
        }
    }

    public static void merge(int[] array, int left, int right, int middle) {
        int i = left;
        int j = middle + 1;
        int[] tmp = new int[array.length];
        int indexCount = left;
        while (i <= middle && j <= right) {
            if (array[i] > array[j]) {
                tmp[indexCount++] = array[j++];
            } else {
                tmp[indexCount++] = array[i++];
            }
        }
        while (i <= middle) {
            tmp[indexCount++] = array[i++];
        }
        while (j <= right) {
            tmp[indexCount++] = array[j++];
        }
        for (int k = left; k <= right; k++) {
            array[k] = tmp[k];
        }
    }

    public static void runStressTest() {
        Random random = new Random();
        int testCount = 0; // Count successful tests

        while (true) {
            testCount++;

            // Generate a random array with random values
            int[] array = generateRandomArray(random);

            // Clone for expected output
            int[] expected = array.clone();
            Arrays.sort(expected); // Java's built-in correct sorting

            // Clone array to be sorted by merge sort
            int[] arrayToTest = array.clone();
            arrayToTest = solution(arrayToTest, 0, arrayToTest.length - 1);

            // Verify the result
            if (!Arrays.equals(arrayToTest, expected)) {
                System.out.printf("Test %d failed!%n", testCount);
                System.out.printf("Original: %s%n", Arrays.toString(array));
                System.out.printf("Expected: %s%n", Arrays.toString(expected));
                System.out.printf("Actual:   %s%n", Arrays.toString(arrayToTest));
                break; // Stop on failure
            } else {
                System.out.printf("Test %d passed.%n", testCount);
            }
        }
    }

    // Generates a random array of variable size with random values
    private static int[] generateRandomArray(Random random) {
        int size = random.nextInt(50) + 1; // Random size between 1 and 50
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(200) - 100; // Values from -100 to 100
        }

        return array;
    }
}
