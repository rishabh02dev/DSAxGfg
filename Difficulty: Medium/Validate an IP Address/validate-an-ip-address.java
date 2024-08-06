//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;

public class validip {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();

            if (obj.isValid(s))
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    public boolean isValid(String str) {
        String str2 = str.replace("."," ");
        String[] strarr = str2.split(" ");
        if(strarr.length<4 || strarr.length>4 ) return false;
        for(String s:strarr){
            if(s.trim().equals("")) return false;
            if(s.length()>1 && s.startsWith("0")) return false;
            int a = Integer.parseInt(s);
            if(a<0 || a>255) return false;
        }
        return true;
    }
}

