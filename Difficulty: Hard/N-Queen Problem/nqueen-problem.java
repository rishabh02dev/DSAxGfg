//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if (ans.size() == 0)
                System.out.println("-1");
            else {
                ans.sort((list1, list2) -> {
                    int size = Math.min(list1.size(), list2.size());
                    for (int i = 0; i < size; i++) {
                        if (!list1.get(i).equals(list2.get(i))) {
                            return list1.get(i) - list2.get(i);
                        }
                    }
                    return list1.size() - list2.size();
                });

                for (int i = 0; i < ans.size(); i++) {
                    System.out.print("[");
                    for (int j = 0; j < ans.get(i).size(); j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java



// User function Template for Java

class Solution {
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
         ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int[] board = new int[n];
        solve(0, n, board, result);
        return result;
    }
    
    private void solve(int col, int n, int[] board, ArrayList<ArrayList<Integer>> result) {
        if (col == n) {
            result.add(createSolution(board));
            return;
        }
        
        for (int row = 0; row < n; row++) {
            if (isSafe(board, col, row)) {
                board[col] = row + 1;
                solve(col + 1, n, board, result);
            }
        }
    }
    
    private boolean isSafe(int[] board, int col, int row) {
        for (int i = 0; i < col; i++) {
            int placedRow = board[i] - 1;
            if (placedRow == row || Math.abs(placedRow - row) == Math.abs(i - col)) {
                return false;
            }
        }
        return true;
    }
    
    private ArrayList<Integer> createSolution(int[] board) {
        ArrayList<Integer> solution = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            solution.add(board[i]);
        }
        return solution;
    }
}