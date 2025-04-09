package code;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        System.out.println("Test " + longestPalindromicSubstring.longestPalindrome("abdbacdse"));
    }

    public String longestPalindrome(String s) {
        char[] stringArray = s.toCharArray();
        int start = 0;
        int end = stringArray.length;
        boolean isPalindrome = false;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < stringArray.length; i++) {
            for (int j = end; j > i; j--) {
                if (stringArray[i] == stringArray[j]) {
                    end--;
                    stringBuilder.setCharAt(i, stringArray[i]);
                    stringBuilder.setCharAt(j, stringArray[j]);

                    break;
                }
            }
        }
        return stringBuilder.toString();
    }
}