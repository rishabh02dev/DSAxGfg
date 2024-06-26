//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] array = new int[n - 1];
            for (int i = 0; i < n - 1; i++) {
                array[i] = Integer.parseInt(str[i]);
            }
            Solution sln = new Solution();
            System.out.println(sln.missingNumber(array, n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int missingNumber(int arr[], int n) {
        // Your Code Here
        // THis is the better approach
        
        int xor1 = 0;
        for(int i=1;i<=n;i++){
            xor1 = xor1^i;
        }
        
        int xor2 = 0;
        for(int i=0;i<n-1;i++){
            xor2 = xor2^arr[i];
        }
        
        return xor1^xor2;
       
        
    }
}



//This is the brute force approach using normal flag
// for(int i=1;i<=n;i++){
//             int flag  = 0;
//             for(int j=0; j<n-1;j++){
//                 if(arr[j]==i){
//                     flag = 1;
//                     break;
//                 }
//             }
//             if(flag==0){
//                 return i;
//             }
//         }
        
//         return 0;

 // int hash[] = new int[n+1];
        
        // for(int i=0;i<n-1;i++){
        //     hash[arr[i]] = 1;
        // }
        
        // for(int i=1; i<=n;i++){
        //     if(hash[i]==0){
        //         return i;
        //     }
        // }
        
        // return -1;