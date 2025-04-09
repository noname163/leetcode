package code;

import java.util.ArrayList;
import java.util.List;

public class RemoveChar {

    public static List<Integer> getRemovableIndices(String str1, String str2) {
        List<Integer> result = new ArrayList<>();
        int n = str1.length();
        int m = str2.length();

        int i = 0, j = 0;

        // Find the first mismatch
        while (j < m && str1.charAt(i) == str2.charAt(j)) {
            i++;
            j++;
        }

        // Store the extra character's index
        char extraChar = str1.charAt(i);
        result.add(i);

        i++; // Skip the first occurrence
        while (i < n && j < m) {
            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            } else if (str1.charAt(i) == extraChar) {
                result.add(i);
            }
            i++;
        }

        return result.isEmpty() ? List.of(-1) : result;
    }

    public static void main(String[] args) {
        System.out.println(getRemovableIndices("abdgggda", "abdggda")); // Output: [3, 4, 5]

    }

}
