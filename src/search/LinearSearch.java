package search;

public class LinearSearch {
    public static int search(int[] array , int number) {
        for (int i : array) {
            if (i == number) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1, 12, 5, 65, 12, 4, 2, 6, 78};
        System.out.println(search(array, 78));
    }
}
