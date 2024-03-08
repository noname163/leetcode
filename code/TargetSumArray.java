package code;

import java.util.HashMap;

public class TargetSumArray {

    public static void main(String[] argv) {
        int[] array = { 3, 2, 4 };
        int[] result = findIndexOfRequire(array, 6);
        int[] result1 = findIndexOfRequireImproveSpeed(array, 6);
        for (Integer integer : result) {
            System.out.println(integer);
        }
        for (Integer integer : result1) {
            System.out.println(integer);
        }
    }

    public static int[] findIndexOfRequire(int[] array, int target) {
        int[] result = new int[2];
        boolean flag = false;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (j != array.length) {
                    if (target == array[i] + array[j]) {
                        result[0] = i;
                        result[1] = j;
                        flag = true;
                        break;
                    }
                }
            }
            if (flag) {
                break;
            }
        }
        return result;
    }

    public static int[] findIndexOfRequireImproveSpeed(int[] array, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> numbsHash = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            int num = target - array[i];
            if (numbsHash.containsKey(num) && numbsHash.get(num) != i) {
                result[0] = numbsHash.get(num);
                result[1] = i;
                break;
            }
            numbsHash.put(array[i], i);
        }
        return result;
    }
}
