//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntMatrix {
    public static int[][] input(BufferedReader br, int n, int m) throws IOException {
        int[][] mat = new int[n][];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for (int j = 0; j < s.length; j++) mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }
}

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int q;
            q = Integer.parseInt(br.readLine());

            int[][] queries = IntMatrix.input(br, q, 2);

            Solution obj = new Solution();
            ArrayList<Integer> res = obj.constructList(q, queries);

            IntArray.print(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static ArrayList<Integer> constructList(int q, int[][] queries) {
        ArrayList<Integer> lst = new ArrayList<>();  // Initialize the list to store results
        int xor = 0;  // Initialize the cumulative XOR value
        
        // Process the queries in reverse order
        for (int i = q - 1; i >= 0; i--) {
            int type = queries[i][0];
            int value = queries[i][1];
            
            if (type == 0) {
                // For '0 x' queries, add the XOR-ed value to the list
                lst.add(value ^ xor);
            } else if (type == 1) {
                // For '1 x' queries, update the cumulative XOR value
                xor ^= value;
            }
        }
        
        // Add the initial value 0 XOR-ed with the cumulative XOR value
        lst.add(0 ^ xor);
        
        // Sort the list to get the final result in ascending order
        Collections.sort(lst);
        
        return lst;
    }
}