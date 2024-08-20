//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      Solution obj = new Solution();
      int ans = obj.subarrayCount(a,n,k);
      System.out.println(ans);
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    
    static int findAns(int arr[], int k) {
        int count = 0;
        int left = 0;
        int right = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        while (right < arr.length) {
            // Add the current element to the map
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);

            while(map.size() > k) {
                map.put(arr[left], map.get(arr[left]) - 1);
                if (map.get(arr[left]) == 0) {
                    map.remove(arr[left]);
                }
                left++;
            }
            count += right - left + 1;
            right++;
        }
        return count;
    }
    static int subarrayCount(int arr[], int N, int k) {
    // code here
      int val1 = findAns(arr, k);
        int val2 = findAns(arr, k - 1);
        return val1 - val2;
    

  }
}
     