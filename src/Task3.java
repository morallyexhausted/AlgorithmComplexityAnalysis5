import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Task3 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        if (line == null || line.trim().isEmpty()) return;

        StringTokenizer tokenizer = new StringTokenizer(line);
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        int[] starts = new int[n];
        int[] ends = new int[n];

        for (int i = 0; i < n; i++) {
            while (!tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            starts[i] = Integer.parseInt(tokenizer.nextToken());
            ends[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int[] points = new int[m];
        int[] originalIndices = new int[m];
        for (int i = 0; i < m; i++) {
            while (!tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            points[i] = Integer.parseInt(tokenizer.nextToken());
            originalIndices[i] = i;
        }

        // Сортируем начала и концы отрезков
        Arrays.sort(starts);
        Arrays.sort(ends);

        int[] answers = new int[m];
        for (int i = 0; i < m; i++) {
            int p = points[i];
            // Количество отрезков, начавшихся <= p
            int countStarted = upperBound(starts, p);
            // Количество отрезков, закончившихся < p
            int countEnded = lowerBound(ends, p);
            
            answers[i] = countStarted - countEnded;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            sb.append(answers[i]).append(i == m - 1 ? "" : " ");
        }
        System.out.println(sb);
    }

    // Возвращает количество элементов <= target (эквивалентно upper_bound минус 1, либо поиск первого элемента > target)
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

    // Возвращает количество элементов < target (эквивалентно поиску первого элемента >= target)
    private static int lowerBound(int[] arr, int target) {
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
