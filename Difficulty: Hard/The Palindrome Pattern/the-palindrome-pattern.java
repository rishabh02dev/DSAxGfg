//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Solution ob = new Solution();
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String input_line[] = read.readLine().trim().split("\\s+");
            int n = Integer.parseInt(input_line[0]);
            String input_line1[] = read.readLine().trim().split("\\s+");
            int[][] a = new int[n][n];
            int c = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = Integer.parseInt(input_line1[c]);
                    c++;
                }
            }
            String ans = ob.pattern(a);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java


class Solution {
    public String pattern(int[][] arr) {
        // Code here
        int n = arr.length;
        
        for(int i = 0; i < n; i++)
        {
            if(isPalindrome(arr,i,0,n-1))
            {
                return i + " " + "R";
            }
        }
        
        for(int i = 0; i < n; i++)
        {
            if(isPalindrome2(arr,i,0,n-1))
            {
                return i + " " + "C";
            }
        }
        
        return "-1";
    }
    public boolean isPalindrome(int[][] arr,int i, int si, int ei)
    {
        while(si <= ei)
        {
            if(arr[i][si] != arr[i][ei])
            {
                return false;
            }
            si++;
            ei--;
        }
        
        return true;
    }
    public boolean isPalindrome2(int[][] arr,int i, int si, int ei)
    {
        while(si <= ei)
        {
            if(arr[si][i] != arr[ei][i])
            {
                return false;
            }
            si++;
            ei--;
        }
        
        return true;
    }
}