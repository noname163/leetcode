package code;

import java.util.Arrays;
import java.util.Random;

public class BinarySearch {
    public static void main(String[] args) {
        // int[] array = { 15, 16 };
        // System.out.println(solution(array, 16));
        runStressTest();
    }

    public static Boolean solution(int[] array, int target) {
        Boolean result = false;
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int middleIndex = (left + right) / 2;
            int middleValue = array[middleIndex];
            if (target < middleValue) {
                right = middleIndex - 1;
            } else if (target > middleValue) {
                left = middleIndex + 1;
            } else {
                return true;
            }
        }
        return result;
    }

    public static void runStressTest() {
        Random random = new Random();
        int testCount = 0; // Count the number of tests executed

        while (true) {
            testCount++;
            // Generate a random sorted array
            int[] sortedArray = generateSortedArray(random);

            // Pick a random target value (sometimes from the array, sometimes not)
            int target = (random.nextBoolean() && sortedArray.length > 0)
                    ? sortedArray[random.nextInt(sortedArray.length)] // Pick an existing value
                    : random.nextInt(200) - 100; // Pick a random value in the range

            // Run the binary search
            boolean result = solution(sortedArray, target);

            // Validate the result using Arrays.binarySearch (Java's built-in function)
            boolean expected = Arrays.binarySearch(sortedArray, target) >= 0;

            // If the results do not match, stop and print details
            if (result != expected) {
                System.out.printf("Test %d failed!%n", testCount);
                System.out.printf("Array:   %s%n", Arrays.toString(sortedArray));
                System.out.printf("Target:  %d%n", target);
                System.out.printf("Expected: %b%n", expected);
                System.out.printf("Actual:   %b%n", result);
                break;
            } else {
                System.out.printf("Test %d passed.%n", testCount);
            }
        }
    }

    private static int[] generateSortedArray(Random random) {
        int size = random.nextInt(50) + 1; // Random size between 1 and 50
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(200) - 100; // Random values between -100 and 100
        }

        Arrays.sort(array); // Ensure the array is sorted
        return array;
    }

}
