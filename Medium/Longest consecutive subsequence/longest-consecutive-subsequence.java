//{ Driver Code Starts
//Initial Template for Java

import java.math.*;
import java.util.*;
import java.io.*;

class Driverclass
{
    // Driver Code
    static class FastReader{ 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader(){ 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
  
        String next(){ 
            while (st == null || !st.hasMoreElements()){ 
                try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
            } 
            return st.nextToken(); 
        } 
  
        String nextLine(){ 
            String str = ""; 
            try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
            return str; 
        } 

        Integer nextInt(){
            return Integer.parseInt(next());
        }
    }
    
	public static void main(String args[])
	{
		FastReader sc = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		int t = sc.nextInt();
		
		while(t>0)
		{
			int n = sc.nextInt();
			int a[] = new int[n];
			
			for(int i=0; i<n; i++)
				a[i] = sc.nextInt();
		    out.println(new Solution().findLongestConseqSubseq(a, n));
		    t--;
		}
		out.close();
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{   
    // arr[] : the input array
    // N : size of the array arr[]
    
    //Function to return length of longest subsequence of consecutive integers.
    
    // static boolean ls(int arr[], int x){
        
    //     for(int i=0; i<arr.length;i++){
    //         if(arr[i]==x){
    //             return true;
    //         }
    //     }
    //     return true;
    // }
	static int findLongestConseqSubseq(int arr[], int N)
	{
	   // add your code here
	   
	   if(N==0){
	       return 0;
	   }
	   
	   Arrays.sort(arr);

	   int last_smaller = Integer.MIN_VALUE;
	   int count = 0;
	    int longest =1;
	   for(int i=0; i<N;i++){
	       
	       if(arr[i]-1==last_smaller){
	           count+=1;
	           last_smaller = arr[i];
	           
	       }else if(arr[i]!=last_smaller){
	           count = 1;
	           last_smaller = arr[i];
	       }
	       
	       longest = Math.max(longest, count);
	   }
	   
	   return longest;
	}
}

//This is the brute force approach to solve this problem
// int longest = 1;
// 	   for(int i=0; i<N;i++){
// 	       int x = arr[i];
// 	       int count = 1;
// 	       while(ls(arr,x+1)==true){
// 	           x = x+1;
// 	           count+=1;
// 	       }
	       
// 	       longest = Math.max(longest, count);
// 	   }
	   
	   //return longest;