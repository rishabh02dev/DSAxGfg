//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            int h = sc.nextInt();
            Solution obj = new Solution();
            int ans = obj.Solve(n,a,h);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends



class Solution {
    static int findMax(int arr[]) {
        int maxi = Integer.MIN_VALUE;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, arr[i]);
        }
        return maxi;
    }

    static int calculatehrs(int arr[], int hours) {
        int totalH = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            totalH += Math.ceil((double) arr[i] / hours);
        }

        return totalH;
    }

    public static int Solve(int n, int[] arr, int h) {
        int low = 1;
        int high = findMax(arr);

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int totalHrs = calculatehrs(arr, mid);

            if (totalHrs <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
