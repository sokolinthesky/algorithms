package sorting;

import java.util.Arrays;

public class SelectionSort implements Sort {

    @Override
    public int[] sort(int[] array) {
        int arrSize = array.length - 1;
        for(int i = 0; i < arrSize; i++) {
            int minPos = i;
            for (int j = i + 1; j < arrSize; j++) {
                if (array[j] < array[minPos]) {
                    minPos = j;
                }
            }
            int temp = array[minPos];
            array[minPos] = array[i];
            array[i] = temp;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {1, 13, 6, 2, 0, 3, 33, 4, 7, 8, 90};
        System.out.println(Arrays.toString(new SelectionSort().sort(array)));
    }
}
