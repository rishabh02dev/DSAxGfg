//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Driver
{
    public static void main(String args[]) 
	{ 
	    Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int []a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            
            int  m= sc.nextInt();
            int []b = new int[m];
            for (int i = 0; i < m; i++) b[i] = sc.nextInt();
            
            double res = new GFG().medianOfArrays(n, m, a, b);
            
            if (res == (int)res) System.out.println ((int)res);
            else System.out.println (res);
        }
    		
	} 
}
// } Driver Code Ends


//User function Template for Java

class GFG 
{ 
    static double medianOfArrays(int n1, int n2, int a[], int b[]) 
    {
        // Your Code Here
        ArrayList<Integer> al = new ArrayList<>();
        
        for(int i=0; i<a.length;i++){
            al.add(a[i]);
        }
        for(int j=0; j<b.length;j++){
            al.add(b[j]);
        }
        
        Collections.sort(al);
        
        int n = al.size();
        double ans = 0;
        if(n%2!=0){
            ans = al.get(n/2);
        }else{
            long mid = al.get(n/2);
            long mid2 = al.get((n/2)-1);
            ans = (mid+mid2)/2.0;
        }
        
        return ans;
    }
}