//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            long n = Long.parseLong(br.readLine().trim());            
            Solution ob = new Solution();
            long ans = ob.reverse_digit(n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public long reverse_digit(long n)
    {
        long reversenum = 0;
        long lastdigit = 0;
        // Code here
        while(n>0){
            lastdigit = n%10;
            reversenum = reversenum*10 + lastdigit;
            n = n/10;
        }
        
        return reversenum;
    }
}