public class Task2 {
    public static void main(String[] args) {
        // Данные из примера: n = 5, k = 2, массив [10, 4, 8, 7, 9]
        int k = 2;
        int[] arr = {10, 4, 8, 7, 9};

        int result = quickSelect(arr, 0, arr.length - 1, k - 1);
        System.out.println(result);
    }

    private static int quickSelect(int[] arr, int left, int right, int targetIndex) {
        if (left == right) {
            return arr[left];
        }

        int mid = left + (right - left) / 2;
        int pivot = arr[mid];

        int i = left;
        int j = right;

        while (i <= j) {
            while (arr[i] > pivot) i++;
            while (arr[j] < pivot) j--;
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        if (targetIndex <= j) {
            return quickSelect(arr, left, j, targetIndex);
        } else if (targetIndex >= i) {
            return quickSelect(arr, i, right, targetIndex);
        } else {
            return arr[targetIndex];
        }
    }
}