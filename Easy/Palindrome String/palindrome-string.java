//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.isPalindrome(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    
    // static int palind(int i, String s) {
    //     // Base case: if the index crosses the middle, return 1 (true)
    //     if (i >= s.length() / 2) {
    //         return 1;
    //     } else {
    //         // Check the characters at the current indices
    //         if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
    //             return 0;
    //         }
    //     }
    //     // Recursive call
    //     return palind(i + 1, s);
    // }
    
    int isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return 0;
            }
            left++;
            right--;
        }
        return 1;
    }
    
}
