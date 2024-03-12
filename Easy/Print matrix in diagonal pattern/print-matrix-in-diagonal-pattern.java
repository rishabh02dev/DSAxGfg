//{ Driver Code Starts
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
            int n = Integer.parseInt(br.readLine().trim());
            int[][] mat = new int[n][n];
            String[] S = br.readLine().trim().split(" ");
            int i = 0;
            int j = 0;
            for(int k = 0; k < S.length; k++){
                mat[i][j] = Integer.parseInt(S[k]);
                j++;
                if(j == n){
                    i++;
                    j = 0;
                }
            }
            Solution obj = new Solution();
            int[] ans = obj.matrixDiagonally(mat);
            for(int it = 0; it < ans.length; it++){
                System.out.print(ans[it] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends

class Solution{
public int[] matrixDiagonally(int[][] mat) {
        int n = mat.length;
        int ans[] = new int[n*n];
        
        int i=0;
        int row=0;
        int col=0;
       
        // Initially we do up
        boolean isDirectionUp = true ;
        while(i<ans.length){
            if(isDirectionUp){
                while(row < n && col<n && row>=0 && col >=0){
                    ans[i++] = mat[row][col];
                    row--;
                    col++;
                }
                // Undo the last change
                row++;
                col--;
                // Now we should reverse the direction
                isDirectionUp = false;
                // Also make the necessary changes to go to down direction
                // Go right if possible
                if(col+1<n){
                    // we can go right
                    col++;
                }
                else{
                    // we can go down
                    row++;
                }
            }
            else{
                while(row < n && col<n && row>=0 && col >=0){
                    ans[i++] = mat[row][col];
                    row++;
                    col--;
                }
                row--;
                col++;
                
                isDirectionUp = true ;
                // Try to go Down, if not possible go right
                if(row+1<n){
                    row++;
                }
                else{
                    col++;
                }
            }
        }
        return ans ;
}
}