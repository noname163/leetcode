package code;

public class SortZeroToTheEnd {
    public void sortZerotToTheEnd(int[] array){
        int replaceIndex = -1;
        for (int i = array.length - 1; i >= 0; i--) {
            if (replaceIndex == -1 && array[i] != 0) {
                replaceIndex = i;
            }
            if (array[i] == 0 && replaceIndex != -1) {
                int tmp = array[i];
                array[i] = array[replaceIndex];
                array[replaceIndex] = tmp;
                replaceIndex -= 1;
            }
        }
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
