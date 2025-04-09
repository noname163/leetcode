package code;

public class AvidHiker {
    public static int countingValleys(int steps, String path) {
        int result = 0;
        int count = 0;
        boolean isInValley = false;
        for (char step : path.toCharArray()) {
            if (step == 'D') {
                count--;
            }
            if (step == 'U') {
                count++;
            }
            if (count < 0) {
                isInValley = true;
            }
            if (count > 0) {
                isInValley = false;
            }
            if (count == 0 && isInValley) {
                result++;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println(countingValleys(8, "UDDDUDUU"));
    }
}
