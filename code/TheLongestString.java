package code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class TheLongestString {
    public static void main(String[] argv) {
        System.out.println(lengthOfLongestSubstring("aanviaj"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 1) {
            return 1;
        }
        if (s.isEmpty()) {
            return 0;
        }
        char[] array = s.toCharArray();
        int result = 0;
        StringBuilder value1 = new StringBuilder();
        StringBuilder value2 = new StringBuilder();
        boolean addValue1 = true;
        for (int i = 0; i < array.length; i++) {
            int indexOfExist1 = value1.indexOf(String.valueOf(array[i]));
            if (indexOfExist1 > -1) {
                value2 = new StringBuilder(value1.subSequence(indexOfExist1 + 1, i));
                addValue1 = false;
            }
            if (value1.length() < value2.length()) {
                value1 = new StringBuilder();
            }
            int indexOfExist2 = value2.indexOf(String.valueOf(array[i]));
            if (indexOfExist2 > -1) {
                value2 = new StringBuilder(value2.subSequence(indexOfExist2 + 1, i));
                addValue1 = true;
            }
            if (value1.length() < value2.length()) {
                value1 = new StringBuilder();
            }
            if (addValue1) {
                value1.append(array[i]);
            }
            if (!addValue1) {
                value2.append(array[i]);
            }
        }
        result = value1.length() > value2.length() ? value1.length() : value2.length();

        return result;
    }
}
