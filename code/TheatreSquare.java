package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TheatreSquare {
    public static long solution(int n, int m, int a) {
        // Calculate the number of flagstones needed along each dimension
        long numberFlagStoneForn = (long) (n + a - 1) / a;
        long numberFlagStoneForm = (long) (m + a - 1) / a;

        // Total number of flagstones required
        long minimumStoneForFullArea = numberFlagStoneForn * numberFlagStoneForm;

        return minimumStoneForFullArea;
    }

    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

    }

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        System.out.println(solution(sc.nextInt(), sc.nextInt(), sc.nextInt()));

    }
}
