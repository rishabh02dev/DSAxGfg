//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            char ch = sc.next().charAt(0);
            int count = sc.nextInt();
            Solution ob = new Solution();
            String result = ob.printString(s, ch, count);

            System.out.println(result);
        }
    }
}
// } Driver Code Ends


class Solution {
    public String printString(String s, char ch, int count) {
        int cur = 0;
        int now = -1;
        char[] arr = s.toCharArray();
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ch) {
                cur++;
                if (cur == count) {
                    now = i;
                    break;
                }
            }
        }

        // If the count-th occurrence of ch is not found, return an empty string
        if (now == -1) {
            return "";
        }
        
        StringBuilder ans = new StringBuilder();
        for (int i = now + 1; i < s.length(); i++) {
            ans.append(s.charAt(i));
        }
        return ans.toString();
    }
}