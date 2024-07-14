//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine().trim());
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(n, arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    String longestCommonPrefix(int n, String arr[]) {
        if (n == 0) return "-1";
        
        // Initialize the prefix with the first string
        String prefix = arr[0];
        
        // Iterate through the array
        for (int i = 1; i < n; i++) {
            // Compare the current prefix with the next string
            while (arr[i].indexOf(prefix) != 0) {
                // Shorten the prefix by one character
                prefix = prefix.substring(0, prefix.length() - 1);
                // If the prefix becomes empty, there is no common prefix
                if (prefix.isEmpty()) return "-1";
            }
        }
        
        return prefix;
    }
}
