import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Task2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        if (line == null || line.trim().isEmpty()) return;

        StringTokenizer tokenizer = new StringTokenizer(line);
        int n = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());

        int[] arr = new int[n];
        int index = 0;
        while (index < n) {
            if (!tokenizer.hasMoreTokens()) {
                String nextLine = reader.readLine();
                if (nextLine == null) break;
                tokenizer = new StringTokenizer(nextLine);
            }
            arr[index++] = Integer.parseInt(tokenizer.nextToken());
        }

        // Искомый индекс в 0-индексации для порядка по убыванию — это k - 1
        int result = quickSelect(arr, 0, n - 1, k - 1);
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

        // Для порядка ПО УБЫВАНИЮ элементы больше пивота идут слева (в начало)
        while (i <= j) {
            while (arr[i] > pivot) {
                i++;
            }
            while (arr[j] < pivot) {
                j--;
            }
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
