//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    int K = Integer.parseInt(element[1]);
		    
		    int arr [] = new int[sizeOfArray];
		    
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		    int res = obj.lenOfLongSubarr(arr, sizeOfArray, K);
		    
		    System.out.println(res);
		}
	}
}



// } Driver Code Ends


//User function Template for Java




class Solution {

    // Function for finding maximum length of subarray with sum equals to k
    public static int lenOfLongSubarr(int arr[], int n, int k) {
        Map<Integer, Integer> map1 = new HashMap<>();
        int sum = 0;
        int maxlen = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum == k) {
                maxlen = Math.max(maxlen, i + 1);
            }

            int rem = sum - k;

            if (map1.containsKey(rem)) {
                int len = i - map1.get(rem);
                maxlen = Math.max(maxlen, len);
            }

            // finally update the values
            if (!map1.containsKey(sum)) {
                map1.put(sum, i);
            }
        }

        return maxlen;
    }
}

//This is the most brute force approach for this problem
        // int len = 0;
        // for(int i=0;i<N;i++){
            
        //     for(int j=i;j<N;j++){
        //         int sum =0;
        //         for(int k=i;k<j;j++){
        //             sum+=A[k];
        //             if(sum==k){
        //                 len = Math.max(len, j-i+1);
        //             }
        //         }
        //     }
        // }
        
        // return len;
        
        
// int len = 0;
//         for(int i=0;i<N;i++){
//             int sum =0;
//             for(int j=i;j<N;j++){
//                 sum+=A[j];
//                 if(sum==K){
//                     len = Math.max(len, j-i+1);
//                 }
//             }
//         }
//         return len;