//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.nextPermutation(N, arr);
            StringBuilder out = new StringBuilder();
            for(int i = 0;i < N;i++)
                out.append(ans.get(i) + " ");
            System.out.println(out);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    
    static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
        
    }


    static List<Integer> nextPermutation(int n, int arr[]){
        
        // code here
        
        List<Integer> al = new ArrayList<>();
        
        int index = -1;
        //yeah loop hmme peak return karegi
        
        for(int i = n-2;i>=0;i--){
            if(arr[i]<arr[i+1]){
                index = i;
                break;
            }
        }
        
        
        if(index==-1){
            reverse(arr, 0, n-1);
        }else{
            //toh ab hm swap karenge index aur piche se smalles element ko
            for(int i=n-1;i>index;i--){
                if(arr[i]>arr[index]){
                    int temp = arr[i];
                    arr[i]  = arr[index];
                    arr[index] = temp;
                    break;
                }
            }
            
            reverse(arr, index+1,n-1);
        }
        
        for (int num : arr) {
            al.add(num);
        }
        
        return al;
    }
}