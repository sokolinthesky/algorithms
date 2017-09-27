package sorting;

import java.util.Arrays;

public class MergeSort implements Sort {

    @Override
    public int[] sort(int[] array) {
        mergeSort(array);
        return array;
    }

    private void mergeSort(int[] array) {
        if (array.length < 2) {
            return;
        }
        int middle = array.length / 2;
        int[] left = new int[middle];
        int[] right = new int[array.length - middle];
        for (int i = 0; i <= middle - 1; i++) { //fill left array; System.arraycopy(array, 0, left, 0, middle - 1 + 1);
            left[i] = array[i];
        }
        for (int i = middle; i <= array.length - 1; i++) { //fill right array
            right[i - middle] = array[i];
        }
        mergeSort(left);
        mergeSort(right);
        merge(left, right, array);
    }

    private void merge(int[] left, int[] right, int[] array) {
        int liftLength = left.length;
        int rightLength = right.length;
        int i = 0; //cursor left array
        int j = 0; //cursor right array
        int k = 0; //cursor result array
        while (i < liftLength && j < rightLength) {
            if (left[i] <= right[j]) {
                array[k] = left[i];
                i++;
            } else {
                array[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < liftLength) { //elements remained in left array
            array[k] = left[i]; i++; k++;
        }
        while(j < rightLength) { //elements remained in right array
            array[k] = right[j]; j++; k++;
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 13, 6, 2, 4, 3, 33, 4, 7, 8, 90};
        System.out.println(Arrays.toString(new MergeSort().sort(array)));
    }
}
