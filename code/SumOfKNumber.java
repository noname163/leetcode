package code;

public class SumOfKNumber {
    public static void main(String[] argv) {
        int[] array = { 1, 3, 4, 5, 6 };
        int k = 12;
        System.out.println(sumInOn(array, k));
    }

    public static boolean sumInOn2(int[] array, int k) {
        for (int i = 0; i < array.length; ++i) {
            for (int j = i + 1; j < array.length; ++j) {
                if (array[i] + array[j] == k)
                    return true;
            }
        }
        return false;
    }

    public static boolean sumInOn(int[] array, int k) {
        int prefixSum[] = new int[array.length];
        prefixSum[0] = array[0];
        for (int i = 1; i < array.length; ++i) {
            prefixSum[i] = prefixSum[i - 1] + array[i];
            if(prefixSum[i] == k) return true;
        }
        return false;
    }
}