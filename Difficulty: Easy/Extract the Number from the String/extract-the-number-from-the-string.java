//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.regex.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.ExtractNumber(S));
        }
    }
}
// } Driver Code Ends


// User function Template for Java


class Solution {
    long ExtractNumber(String sentence) {
        Pattern pattern = Pattern.compile("\\b\\d+\\b");
        Matcher matcher = pattern.matcher(sentence);
        long maxNum = -1;
        while (matcher.find()) {
            long num = Long.parseLong(matcher.group());
            if (!String.valueOf(num).contains("9") && num > maxNum) {
                maxNum = num;
            }
        }
        return maxNum;
    }
}