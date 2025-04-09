package code;

public class HeapSort {
    public static void main(String[] args) {
        // int[] array = { 4, 6, 7, 8, 5, 9 };
        // bubbleUp(array, 4);
        // int[] array = { 15, 2, 5, 9, 11, 5, 6, 12, 19 };
        // bubbleDown(array, 0);
        // array = insert(array, 1);
        // array = delete(array, 2);
        int[] array = { 9, 8, 7, 4, 3, 2, 1 };
        convertArrayToHeap(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    public static void convertArrayToHeap(int[] array) {
        int bubbelDownFrom = array.length / 2;
        for (int i = bubbelDownFrom; i >= 0; i--) {
            bubbleDown(array, i);
        }
    }

    public static void bubbleUp(int[] array, int index) {
        int parentIndex = 0;
        if (index == 0) {
            return;
        }
        if (index % 2 == 0) {
            parentIndex = index / 2;
        }
        if (index % 2 != 0) {
            parentIndex = (index - 1) / 2;
        }
        if (array[parentIndex] > array[index]) {
            swap(array, index, parentIndex);
            bubbleUp(array, parentIndex);
        }
    }

    public static void bubbleDown(int[] array, int index) {
        int leftChildIndex = ((index + 1) * 2) - 1;
        int rightChildIndex = leftChildIndex + 1;
        if (leftChildIndex >= array.length) {
            return;
        }
        if (leftChildIndex < array.length && rightChildIndex > array.length) {
            swap(array, index, leftChildIndex);
            bubbleDown(array, leftChildIndex);
        } else {
            int minIndex = array[leftChildIndex] < array[rightChildIndex] ? leftChildIndex : rightChildIndex;
            swap(array, index, minIndex);
            bubbleDown(array, minIndex);
        }
    }

    public static int[] delete(int[] array, int index) {
        int[] newArray = new int[array.length - 1];
        swap(array, index, array.length - 1);
        bubbleDown(array, index);
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }

    public static int[] insert(int[] array, int value) {
        int[] newArray = new int[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        newArray[newArray.length - 1] = value;
        bubbleUp(newArray, newArray.length - 1);
        return newArray;
    }

    public static void swap(int[] array, int index1, int index2) {
        int value1 = array[index1];
        int value2 = array[index2];
        array[index1] = value2;
        array[index2] = value1;
    }
}
