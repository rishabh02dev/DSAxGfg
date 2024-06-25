//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            String S[] = read.readLine().split(" ");
            int[] arr = new int[N];

            int D = Integer.parseInt(read.readLine());

            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.leastWeightCapacity(arr, N, D));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    static int findDays(int weights[], int value){
         int days = 1; 
        int load = 0;
        int n = weights.length;
        for (int i = 0; i < n; i++) {
            if (load + weights[i] > value) {
                days += 1; 
                load = weights[i]; 
            } else {
              
                load += weights[i];
            }
        }
        return days;
    }
    static int leastWeightCapacity(int[] weights, int n, int days ) {
        // code here
        int low = Integer.MIN_VALUE, high = 0;
        for (int i = 0; i < weights.length; i++) {
            high += weights[i];
            low = Math.max(low, weights[i]);
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            int numberOfDays = findDays(weights, mid);
            if (numberOfDays <= days) {
                
                high = mid - 1;
            } else {
                
                low = mid + 1;
            }
        }
        return low;
    }
};