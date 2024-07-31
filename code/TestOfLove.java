package code;

public class TestOfLove {
    public static boolean solution(int[] condition, String[] segment) {
        boolean result = false;
        int riverLength = condition[0];
        int jumpLength = condition[1];
        int swimLength = condition[2];
        if (jumpLength > riverLength || (jumpLength == riverLength && segment[riverLength - 1].equals("L"))) {
            return true;
        }
        int maxIndexLogCanLand = segmentIndex(0, jumpLength, segment, "L");
        int maxIndexWaterCanLand = segmentIndex(0, swimLength, segment, "W");
        if (maxIndexLogCanLand >= 0) {
            for (int i = maxIndexLogCanLand; i < segment.length; i++) {
                maxIndexLogCanLand = segmentIndex(i, jumpLength, segment, "L");
                maxIndexWaterCanLand = segmentIndex(i, swimLength, segment, "W");
                if (maxIndexLogCanLand > 0) {
                    i = maxIndexLogCanLand;
                    if (segment.length - i <= jumpLength) {
                        return true;
                    }
                } else if (maxIndexWaterCanLand > 0 && maxIndexLogCanLand < 0) {
                    i = maxIndexWaterCanLand;
                    if (segment[i + 1].equals("C") || (segment[i + 1].equals("W") && swimLength == 0)) {
                        return false;
                    }
                    swimLength--;
                }
            }
        }
        return result;
    }

    private static int segmentIndex(int start, int end, String[] segment, String segmentName) {
        int result = -1;
        for (int i = start; i < segment.length; i++) {
            if (end == 0) {
                return result;
            }
            if (segment[i].equals(segmentName)) {
                result = i;
            }
            end--;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] condition = { 6, 1, 1 };
        String[] segment = { "L", "W", "L", "L", "W", "L" };
        System.out.println(solution(condition, segment));
    }
}
