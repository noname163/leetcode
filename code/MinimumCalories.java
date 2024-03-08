package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MinimumCalories {

    public static void main(String[] argv) {
        var test = new MinimumCalories();
        int[][] contests = {
                { 5, 1 },
                { 2, 1 },
                { 1, 1 },
                { 8, 1 },
                { 10, 0 },
                { 5, 0 }
        };

        // Convert array to List<List<Integer>>
        List<List<Integer>> lists = arrayToListList(contests);
        System.out.println(luckBalance(3, lists));

    }

    public long marcsCakewalk(List<Integer> calorie) {
        long result = 0;
        Collections.sort(calorie, Collections.reverseOrder());

        for (int i = 0; i < calorie.size(); i++) {
            result += Math.pow(2, i) * calorie.get(i);
        }
        return result;
    }

    public static int luckBalance(int k, List<List<Integer>> contests) {
        int result = 0;
        List<Integer> importanceList = sort(contests);
        if (importanceList.size()==0) {
            for (List<Integer> list : contests) {
                if (list.get(1) == 0) {
                    result += list.get(0);
                }
            }
        }
        if (k == 0 && importanceList.size() > 0) {
            for (List<Integer> list : contests) {
                if (list.get(1) == 1) {
                    result -= list.get(0);
                } else {
                    result += list.get(0);
                }
            }
        }
        if (k != 0 && importanceList.size() > 0) {
            int mustCorrect = k - importanceList.size();
            int count = mustCorrect;
            for (Integer integer : importanceList) {
                if(mustCorrect>0){
                    result+=integer;
                }
                if(mustCorrect<0 && count !=0){
                    result-=integer;
                    count++;
                }
            }
            for (List<Integer> list : contests) {
                if (list.get(1) == 0) {
                    result += list.get(0);
                }
            }
        }
        return result;
    }

    public static List<Integer> sort(List<List<Integer>> lists) {
        List<Integer> result = new ArrayList<>();
        int unSorted = 0;
        int minimumValue = 99999999;
        int minimumIndex = -1;
        int listSize = lists.size();
        boolean findUnsortNumber = false;
        while (result.size() != ( listSize - unSorted)) {
            for (int i = 0; i < lists.size(); i++) {
                int currentValue = lists.get(i).get(0);
                if (currentValue < minimumValue && lists.get(i).get(1) == 1) {
                    minimumValue = lists.get(i).get(0);
                    minimumIndex = i;
                }
                if (lists.get(i).get(1) == 0 && !findUnsortNumber) {
                    unSorted += 1;
                }
            }
            findUnsortNumber = true;
            result.add(lists.get(minimumIndex).get(0));
            lists.remove(minimumIndex);
            minimumValue = 99999999;
        }
        return result;
    }

    private static void printListOfLists(List<List<Integer>> lists) {
        for (List<Integer> list : lists) {
            System.out.println(list.get(0) + " " + list.get(1));
        }
    }

    private static List<List<Integer>> arrayToListList(int[][] array) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int[] row : array) {
            lists.add(Arrays.asList(row[0], row[1]));
        }
        return lists;
    }
}
