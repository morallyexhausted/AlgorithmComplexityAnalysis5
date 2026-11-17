import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {
        // Отрезки из примера: [1, 5], [3, 7], [4, 4]
        int[] starts = {1, 3, 4};
        int[] ends = {5, 7, 4};
        // Точки: 1, 4, 6, 8
        int[] points = {1, 4, 6, 8};

        Arrays.sort(starts);
        Arrays.sort(ends);

        for (int i = 0; i < points.length; i++) {
            int p = points[i];

            // Количество отрезков, у которых начало <= p
            int countStarted = upperBound(starts, p);

            // Количество отрезков, у которых конец < p (строго меньше)
            int countEnded = strictLowerBound(ends, p);

            int answer = countStarted - countEnded;

            System.out.print(answer + (i == points.length - 1 ? "" : " "));
        }
        System.out.println();
    }

    // Возвращает количество элементов <= target
    private static int upperBound(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (arr[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    // Возвращает количество элементов строго меньше target (< target)
    private static int strictLowerBound(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}