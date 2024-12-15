package code;

import java.util.HashSet;

public class ShohagLovesStrings {
    public static String solution(String input) {
        char[] inputs = input.toCharArray();
        int numberOfSubString = 0;
        String result = "";
        for (int i = 0; i < inputs.length; i++) {
            HashSet<Character> inputSet = new HashSet<>();
            String tmpResult = "";
            for (int j = i; j < inputs.length; j++) {
                char tmp = input.charAt(j);
                inputSet.add(input.charAt(j));
                tmpResult += tmp;
                numberOfSubString = inputSet.size() + ((tmpResult.length() * (tmpResult.length() - 1)) / 2);
                if (numberOfSubString % 2 == 0) {
                    result = tmpResult;
                    break;
                }

                if (result.length() > 0) {
                    return result;
                }
            }
        }
        return "-1";

    }

    public static void main(String[] args) {
        System.out.println(solution("ab"));
    }
}
