package sorting;

import java.util.Arrays;

public class InsertionSort implements Sort {
    @Override
    public int[] sort(int[] array) {
        int arrSize = array.length - 1;
        for (int i = 1; i < arrSize; i++) {
            int currentElement = array[i];
            int indexToSet = 0;
            for (int j = i; j > 0; j--) {
                if (array[j - 1] > currentElement) {
                    array[j] = array[j - 1];
                    continue;
                }
                indexToSet = j;
                break;
            }
            array[indexToSet] = currentElement;
        }
        return array;
    }

    public int[] sort2(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; ++i) {
            int key = array[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {1, 13, 6, 2, 0, 3, 33, 4, 7, 8, 90};
        System.out.println(Arrays.toString(new InsertionSort().sort(array)));
    }
}
