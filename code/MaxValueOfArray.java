package code;

import java.util.ArrayList;
import java.util.List;

public class MaxValueOfArray {
    public int findMaxValue(int n, List<List<Integer>> queries) {
        int result = 0;
        int[] caculateArray = new int[n];
        int numberOfLoop = queries.size();
        while (numberOfLoop > 0) {
            int start = queries.get(numberOfLoop - 1).get(0);
            int end = queries.get(numberOfLoop - 1).get(1);
            int plush = queries.get(numberOfLoop - 1).get(2);
            for (int i = start-1; i < end; i++) {
                caculateArray[i] = caculateArray[i] + plush;
            }
            numberOfLoop--;
        }
        for (int i : caculateArray) {
            if (result < i) {
                result = i;
            }
        }
        return result;
    }
}
