package search;

public class BinarySearch {
    public static int serach(int[] array, int value) {
        int left = 0;
        int right = array.length;
        while(left < right) {
            int mid = ((right - left) / 2) + left;
            int elem = array[mid];
            if (elem == value) return mid;
            else if (elem > value) {
                right = mid;
                continue;
            }
            left = mid + 1;
        }
        return -1;
    }

    // Returns index of x if it is present in arr[l..r], else
    // return -1
    public static int binarySearchRecurcive(int arr[], int l, int r, int x)
    {
        if (r>=l)
        {
            int mid = l + (r - l)/2;

            // If the element is present at the middle itself
            if (arr[mid] == x)
                return mid;

            // If element is smaller than mid, then it can only
            // be present in left subarray
            if (arr[mid] > x)
                return binarySearchRecurcive(arr, l, mid-1, x);

            // Else the element can only be present in right
            // subarray
            return binarySearchRecurcive(arr, mid+1, r, x);
        }

        // We reach here when element is not present in array
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 10};
        System.out.println(serach(array, 10));

        int arr[] = {2,3,4,10,40};
        int n = arr.length;
        int x = 10;
        int result = binarySearchRecurcive(arr,0,n-1,x);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index "+result);
    }
}
