package sorting;

import java.util.Arrays;

public class BubbleSort implements Sort {
    @Override
    public int[] sort(int[] array) {
        boolean swapped = true;
        int arraySize = array.length - 1;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < arraySize; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }
            }
            --arraySize;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {1, 13, 6, 2, 0, 3, 33, 4, 7, 8, 90};
        System.out.println(Arrays.toString(new BubbleSort().sort(array)));
    }
}
