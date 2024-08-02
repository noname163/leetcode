package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TestOfLove {
    public static boolean solution(int[] condition, char[] segment) {
        boolean result = true;
        List<Integer> logs = new ArrayList<>();
        int nextLog = 0;
        int currentPosition = -1;
        int numberOfJump = condition[1];
        int numberOfSwim = condition[2];
        for (int i = 0; i < segment.length; i++) {
            if (segment[i] == 'L') {
                logs.add(i);
            }
        }
        logs.add(segment.length);
        while (currentPosition < segment.length) {
            if (numberOfJump >= logs.get(nextLog) - currentPosition) {
                currentPosition = logs.get(nextLog);
            } else {
                currentPosition += numberOfJump;
                if (currentPosition >= segment.length) {
                    return true;
                } else {
                    while (currentPosition < segment.length && currentPosition < logs.get(nextLog)) {
                        if (segment[currentPosition] != 'C' && numberOfSwim > 0) {
                            currentPosition++;
                            numberOfSwim--;
                        } else {
                            return false;
                        }
                    }
                }
            }
            nextLog++;
        }
        return result;
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
        int test = sc.nextInt();
        while (test > 0) {
            int[] condition = { sc.nextInt(), sc.nextInt(), sc.nextInt() };
            char[] segment = sc.nextLine().toCharArray();
            if (solution(condition, segment)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            test--;
        }
    }
}
