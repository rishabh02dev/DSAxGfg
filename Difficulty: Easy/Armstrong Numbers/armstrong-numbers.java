//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.armstrongNumber(n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    static String armstrongNumber(int n) {
        // code here
        int ans = n;
        int val = 0;
        int armstrong = 0;
        while(n>0){
            val = n%10;
            armstrong += Math.pow(val,3);
            n = n/10;
        }
        if(ans==armstrong){
            return "true";
        }else{
            return "false";
        }
    }
}