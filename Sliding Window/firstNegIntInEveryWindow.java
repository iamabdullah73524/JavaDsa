
import java.util.*;

public class FirstNegative {

    static List<Integer> firstNegInt(int arr[], int k) {

        int n = arr.length;
        Deque<Integer> dq = new ArrayDeque<>();
        ArrayList<Integer> result = new ArrayList<>();

        // First window
        for (int i = 0; i < k; i++) {
            if (arr[i] < 0) {
                dq.offerLast(i);
            }
        }

        // Remaining windows
        for (int i = k; i < n; i++) {

            // Add previous window result
            if (dq.isEmpty()) {
                result.add(0);
            } else {
                result.add(arr[dq.peekFirst()]);
            }

            // Remove index outside the window
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // Add current element if negative
            if (arr[i] < 0) {
                dq.offerLast(i);
            }
        }

        // Last window result
        if (dq.isEmpty()) {
            result.add(0);
        } else {
            result.add(arr[dq.peekFirst()]);
        }

        return result;
    }

    public static void main(String[] args) {

        int arr[] = { 12, -1, -7, 8, -15, 30, 16, 28 };
        int k = 3;

        List<Integer> result = firstNegInt(arr, k);

        System.out.println("First Negative in Every Window:");

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
