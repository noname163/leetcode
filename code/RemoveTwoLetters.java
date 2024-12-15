import java.util.HashSet;
import java.util.Set;

public class RemoveTwoLetters {
    public static int solution(String input) {
        Set<String> result = new HashSet<>();
        for (int i = 0; i < input.length() - 1; i++) {
            StringBuilder temp = new StringBuilder(input);
            result.add(temp.delete(i, i + 1).toString());
        }
        return result.size();
    }

    public static void main(String[] args) {
        System.out.println(solution("aaabcc"));
    }
}
