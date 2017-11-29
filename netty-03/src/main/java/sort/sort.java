package sort;

public class sort {
    public static void main(String[] args) {

        int[] arr = {10, 2, 3, 4, 9, 5, 6, 7, 1, 0, 8};
        for (int i : bubleSort(arr)) {
            System.out.print(i + " ");
        }
        System.out.print("\n");
        int[] arr1 = {10, 2, 3, 4, 9, 5, 6, 7, 1, 0, 8};
        for (int i : quickSort(arr1, 0, arr1.length - 1)) {
            System.out.print(i + " ");
        }

    }

    public static int[] bubleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        return arr;
    }

    static int[] quickSort(int n[], int left, int right) {
        int dp;
        if (left < right) {
            dp = partition(n, left, right);
            quickSort(n, left, dp - 1);
            quickSort(n, dp + 1, right);
        }
        return n;
    }

    static int partition(int n[], int left, int right) {
        int pivot = n[left];
        while (left < right) {
            while (left < right && n[right] >= pivot)
                right--;
            if (left < right)
                n[left++] = n[right];
            while (left < right && n[left] <= pivot)
                left++;
            if (left < right)
                n[right--] = n[left];
        }
        n[left] = pivot;
        return left;
    }


    public static int[] swap(int[] arr, int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        return arr;
    }

}
