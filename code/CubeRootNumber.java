package code;

public class CubeRootNumber {
    public static void main(String[] args) {
        System.out.println(solution(9));
    }

    public static int solution(int n) {
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (Math.pow(mid, 3) > n) {
                right = mid - 1;
            } else if (Math.pow(mid, 3) <= n && Math.pow(mid + 1, 3) <= n) {
                left = mid + 1;
            } else
                return mid;
        }
        return 0;
    }
}
