package code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GorillaAndPermutation {
    public static void solution(int n, int m, int k) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            result.add(i);
        }
        // find large number that match the f(i)
        int f = n;
        for (Integer integer : result) {
            if (integer > f && integer >= k) {
                f = integer;
            }
        }
        // find all posible number match g(i)
        Set<Integer> gList = new HashSet<>();
        for (Integer integer : result) {
            if (integer >= m) {
                gList.add(integer);
            }
        }
        List<Integer> resultFinal = new ArrayList<>();
        resultFinal.add(f);
        for (Integer integer : result) {
            if (!gList.contains(integer)) {
                resultFinal.add(integer);
            }
        }
        for (Integer integer : gList) {
            if (integer != f) {
                resultFinal.add(integer);
            }
        }
        for (Integer integer : resultFinal) {
            System.out.println(integer);
        }
    }

    public static void main(String[] args) {
        solution(5, 2, 5);
    }
}
