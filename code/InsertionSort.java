package code;

import java.util.Arrays;
import java.util.Random;

public class InsertionSort {
    public static void main(String[] args) {
        // runTests(5000, 15, 100);
        // runTestsUntilFailure();
        solution(new int[] { 6, 8, 7, 3, 4, 1, 7 });
    }

    public static int[] solution(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) {
                int insertNumber = a[i];
                int insertIndex = 0;
                for (int j = i - 1; j >= 0; j--) {
                    if (a[j] < insertNumber) {
                        insertIndex = j + 1;
                        break;
                    }
                    a[j + 1] = a[j];
                }
                a[insertIndex] = insertNumber;
            }
        }
        return a;
    }

    public static int[] insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j = j - 1;
            }
            a[j + 1] = key;
        }
        return a;
    }

    public static void runTestsUntilFailure() {
        Random random = new Random();
        int testCount = 0; // Keep track of the number of tests run

        while (true) {
            testCount++;
            // Generate a random array with random size and values
            int[] array = generateRandomArray(random);

            // Clone the array to test and another for expected output
            int[] arrayToTest = array.clone();
            int[] expected = array.clone();

            // Sort the expected array using Java's Arrays.sort (ground truth)
            Arrays.sort(expected);

            // Run the algorithm to test
            InsertionSort.solution(arrayToTest);

            // Check if the result matches the expected output
            if (!Arrays.equals(arrayToTest, expected)) {
                System.out.printf("Test %d failed!%n", testCount);
                System.out.printf("Original: %s%n", Arrays.toString(array));
                System.out.printf("Expected: %s%n", Arrays.toString(expected));
                System.out.printf("Actual:   %s%n", Arrays.toString(arrayToTest));
                break; // Exit the loop on failure
            } else {
                System.out.printf("Test %d passed.%n", testCount);
            }
        }
    }

    private static int[] generateRandomArray(Random random) {
        int size = random.nextInt(50) + 1; // Random size between 1 and 50
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(200) - 100; // Random values between -100 and 100
        }

        return array;
    }

    public static void runTests(int numberOfTests, int arraySize, int maxValue) {
        Random random = new Random();

        for (int test = 1; test <= numberOfTests; test++) {
            // Generate a random array
            int[] array = generateRandomArray(random, arraySize, maxValue);

            // Clone the array to avoid mutating the original
            int[] arrayToTest = array.clone();
            int[] expected = array.clone();

            // Sort the expected array using Java's Arrays.sort (ground truth)
            Arrays.sort(expected);

            // Run the algorithm to test
            InsertionSort.solution(arrayToTest);

            // Check if the result matches the expected output
            if (Arrays.equals(arrayToTest, expected)) {
                System.out.printf("Test %d passed.%n", test);
            } else {
                System.out.printf("Test %d failed!%n", test);
                System.out.printf("Original: %s%n", Arrays.toString(array));
                System.out.printf("Expected: %s%n", Arrays.toString(expected));
                System.out.printf("Actual:   %s%n", Arrays.toString(arrayToTest));
            }
        }
    }

    private static int[] generateRandomArray(Random random, int maxSize, int maxValue) {
        int size = random.nextInt(maxSize) + 1; // Ensure at least one element
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(maxValue + 1); // Random values from 0 to maxValue
        }

        return array;
    }
}
