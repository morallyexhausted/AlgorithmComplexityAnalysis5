import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Task1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        if (line == null || line.trim().isEmpty()) return;
        
        int n = Integer.parseInt(line.trim());
        int[] arr = new int[n];
        
        StringTokenizer tokenizer = null;
        int index = 0;
        while (index < n) {
            if (tokenizer == null || !tokenizer.hasMoreTokens()) {
                String nextLine = reader.readLine();
                if (nextLine == null) break;
                tokenizer = new StringTokenizer(nextLine);
            }
            arr[index++] = Integer.parseInt(tokenizer.nextToken());
        }

        quickSort(arr, 0, n - 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i]).append(i == n - 1 ? "" : " ");
        }
        System.out.println(sb);
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;
        int pivot = arr[mid];

        int i = left;
        int j = right;

        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
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

        if (left < j) {
            quickSort(arr, left, j);
        }
        if (i < right) {
            quickSort(arr, i, right);
        }
    }
}
