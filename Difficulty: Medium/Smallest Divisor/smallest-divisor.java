//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n = sc.nextInt();
            int K;
            K = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) nums[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.smallestDivisor(nums, K);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int findTotalSum(int nums[],int divisor){
        int sum=0;
        for(int i:nums) sum+=Math.ceil((double)i/(double)divisor);
        return sum;
    }
    public static int smallestDivisor(int[] nums, int K) {
        int max=Integer.MIN_VALUE;
        for(int i:nums) max=Math.max(max,i);
        int l=1,r=max,ans=-1;
        while(l<=r){
            int mid=(l+r)/2;
            int currSum=findTotalSum(nums,mid);
            if(currSum<=K){
                ans=mid;
                r=mid-1;
            }else l=mid+1;
        }
        return ans;
    }
}