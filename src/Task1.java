public class Task1 {
    public static void main(String[] args) {
        // Данные из примера: n = 6, массив [5, 1, 4, 2, 8, 3]
        int[] arr = {5, 1, 4, 2, 8, 3};

        quickSort(arr, 0, arr.length - 1);

        // Вывод результата
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i == arr.length - 1 ? "" : " "));
        }
        System.out.println();
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;
        int pivot = arr[mid];

        int i = left;
        int j = right;

        while (i <= j) {
            while (arr[i] < pivot) i++;
            while (arr[j] > pivot) j--;
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        if (left < j) quickSort(arr, left, j);
        if (i < right) quickSort(arr, i, right);
    }
}