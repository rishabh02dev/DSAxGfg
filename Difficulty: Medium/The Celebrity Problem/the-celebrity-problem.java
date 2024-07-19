//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java


class Solution
{ 
    // Function to find if there is a celebrity in the party or not.
    
    static boolean knows(int M[][], int a, int b) {
        return M[a][b] == 1;
    }
    
    int celebrity(int M[][], int n) {
        // Push all people onto the stack.
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            st.push(i);
        }
        
        // Extract top 2 elements and compare them.
        while (st.size() > 1) {
            int a = st.pop();
            int b = st.pop();
            
            if (knows(M, a, b)) {
                st.push(b);
            } else {
                st.push(a);
            }
        }
        
        // The potential candidate.
        int candidate = st.pop();
        
        // Check if the candidate is a celebrity.
        // Row check: candidate should not know anyone.
        for (int i = 0; i < n; i++) {
            if (i != candidate && knows(M, candidate, i)) {
                return -1;
            }
        }
        
        // Column check: everyone should know the candidate.
        for (int i = 0; i < n; i++) {
            if (i != candidate && !knows(M, i, candidate)) {
                return -1;
            }
        }
        
        return candidate;
    }
}
