package code;

import java.util.HashSet;
import java.util.Set;

public class MaximumPossibleScore {
    public static void main(String[] args) {
        int n = 17 * 2 * 3 * 7 * 11 * 8;
        Set<Integer> listPrime = listPrimeNumber(n);
        for (Integer i : listPrime) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("Prime score: " + calculatePrime(n, listPrime));
    }

    public static int calculatePrime(int n, Set<Integer> primeOfNum) {
        Set<Integer> primes = new HashSet<>();
        for (Integer integer : primeOfNum) {
            if (n % integer == 0) {
                primes.add(integer);
            }
        }
        if (primes.size() > 1) {
            return primes.size() - 1;
        }
        return primes.size();
    }

    public static Set<Integer> listPrimeNumber(int n) {
        Set<Integer> result = new HashSet<>();
        result.add(2);
        result.add(3);
        result.add(5);
        for (int i = 3; i <= n; i += 2) {
            if (i % 2 != 0 && i % 3 != 0 && i % 5 != 0) {
                result.add(i);
            }
        }
        result.add(n);
        return result;
    }
}
