//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.maxSum(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution{
     public int maxSum(int n) {
        if (n <= 3) {
            return n;
        }
        HashMap<Integer, Integer> m = new HashMap<>();
        return MaxSum(n, m);
    }
    private static int MaxSum(int n, HashMap<Integer, Integer> m) {
        if (n <= 3) {
            return n;
        }
        if (m.containsKey(n)) {
            return m.get(n);
        }
        int max = Math.max(n, MaxSum(n / 2, m) + MaxSum(n / 3, m) + MaxSum(n / 4, m));
        m.put(n, max);
        return max;
    }
}
