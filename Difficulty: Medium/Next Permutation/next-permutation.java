//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine()); // Number of test cases
        while (tc-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int N = arr.length;
            Solution ob = new Solution();
            ob.nextPermutation(arr); // Generate the next permutation
            StringBuilder out = new StringBuilder();
            for (int i = 0; i < N; i++) {
                out.append(arr[i] + " "); // Corrected: use arr[i] instead of arr.get(i)
            }
            System.out.println(out.toString().trim()); // Print the output
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    void nextPermutation(int[] arr) {
        int n = arr.length;
        int i = n - 2;

        // Step 1: Find the first decreasing element from the end
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }

        // Step 2: If a valid 'i' is found, find the next larger element to swap
        if (i >= 0) {
            int j = n - 1;
            while (j >= 0 && arr[j] <= arr[i]) {
                j--;
            }
            // Swap arr[i] and arr[j]
            swap(arr, i, j);
        }

        // Step 3: Reverse the subarray from i + 1 to the end
        reverse(arr, i + 1, n - 1);
    }

    // Helper method to swap two elements in the array
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Helper method to reverse a subarray
    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
}
