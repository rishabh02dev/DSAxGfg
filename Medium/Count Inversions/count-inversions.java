//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {

    public static long merge(long arr[], int si, int mid, int ei) {
        long[] merged = new long[ei - si + 1];
        int first = si;
        int second = mid + 1;
        int x = 0;
        long count = 0;
        
        while (first <= mid && second <= ei) {
            if (arr[first] <= arr[second]) {
                merged[x++] = arr[first++];
            } else {
                merged[x++] = arr[second++];
                count += (mid - first + 1);
            }
        }
        
        while (first <= mid) {
            merged[x++] = arr[first++];
        }
        
        while (second <= ei) {
            merged[x++] = arr[second++];
        }
        
        for (int i = 0, j = si; i < merged.length; i++, j++) {
            arr[j] = merged[i];
        }
        
        return count;
    }
    
    public static long divide(long arr[], int si, int ei) {
        long count = 0;
        if (si < ei) {
            int mid = si + (ei - si) / 2;
            count += divide(arr, si, mid);
            count += divide(arr, mid + 1, ei);
            count += merge(arr, si, mid, ei);
        }
        return count;
    }
    
    static long inversionCount(long arr[], long N) {
        return divide(arr, 0, (int) N - 1);
    }
}


//This is the most brute form approach for this count inversions problems
// long cnt = 0;
//         for(int i=0; i<n-1;i++){
//             for(int j=i+1; j<n; j++){
//                 if(arr[i]>arr[j]){
//                     cnt++;
//                 }
//             }
//         }
        
        // return cnt;