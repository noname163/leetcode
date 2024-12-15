package code;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class GorillaAndPermutation {
    public static void solution(int n, int m, int k) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            result.add(i);
        }

        List<Integer> resultFinal = new ArrayList<>();
        Set<Integer> insertIndex = new HashSet<>();
        for (int i = result.size() - 1; i >= 0; i--) {
            if (result.get(i) >= k) {
                resultFinal.add(result.get(i));
                insertIndex.add(i);
            }
        }
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i) > m && !insertIndex.contains(i)) {
                resultFinal.add(result.get(i));
                insertIndex.add(i);
            }
        }
        if (!result.isEmpty()) {
            for (int i = 0; i < result.size(); i++) {
                if (!insertIndex.contains(i)) {
                    resultFinal.add(result.get(i));
                }
            }
        }
        for (Integer integer : resultFinal) {
            System.out.print(integer + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int test = scanner.nextInt();
        while (test > 0) {
            solution(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
            test--;
        }

    }
}
