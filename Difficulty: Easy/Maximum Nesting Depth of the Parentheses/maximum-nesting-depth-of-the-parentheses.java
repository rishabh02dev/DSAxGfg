//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            sc.nextLine();
            String s;
            s = sc.next();
            
            Solution obj = new Solution();
            int res = obj.maxDepth(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int maxDepth(String s) {
        // code here
        char[] arr = s.toCharArray();
        
        int count = 0;
        int maxdepth = 0;
        
        for(int i =0; i<arr.length;i++){
            if(arr[i]=='('){
                count++;
                maxdepth = Math.max(count,maxdepth);
            }
            else if(arr[i]==')'){
                count--;
            }
        }
        
        return maxdepth;
    }
}
        
