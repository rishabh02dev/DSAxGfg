//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int m = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.findPages(n, a, m));
        }
    }
}
// } Driver Code Ends


// User function Template for Java



class Solution {

    static int CountStudents(int arr[], long pages) {
        int n = arr.length;
        int students = 1;
        long pages_student = 0;
        for (int i = 0; i < n; i++) {
            if (pages_student + arr[i] <= pages) {
                pages_student += arr[i];
            } else {
                students++;
                pages_student = arr[i];
            }
        }
        return students;
    }

    // Function to find minimum number of pages.
    public static long findPages(int n, int[] arr, int m) {
        if (m > n) {
            return -1;
        }

        long low = Arrays.stream(arr).max().getAsInt();
        long high = Arrays.stream(arr).sum();
        long result = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            int students = CountStudents(arr, mid);
            if (students <= m) {
                result = mid; // Try to find a smaller maximum number of pages
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }
}
