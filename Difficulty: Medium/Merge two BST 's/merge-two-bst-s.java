//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.math.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

class GFG {
    static Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.equals('N')) return null;
        String[] s = str.split(" ");

        Node root = new Node(Integer.parseInt(s[0]));
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        // Starting from the second element
        int i = 1;
        while (!q.isEmpty() && i < s.length) {
            // Get and remove the front of the queue
            Node currNode = q.remove();

            // Get the curr node's value from the string
            String currVal = s[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the curr node
                currNode.left = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= s.length) break;
            currVal = s[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the curr node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.right);
            }

            i++;
        }

        return root;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {
            String s = br.readLine();
            Node root1 = buildTree(s);

            s = br.readLine();
            Node root2 = buildTree(s);

            Solution T = new Solution();
            List<Integer> ans = T.merge(root1, root2);
            for (int i = 0; i < ans.size(); i++) System.out.print(ans.get(i) + " ");
            System.out.println();

            t--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java

/*
class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}

*/
class Solution {
    
    void addNode(Node node,ArrayList<Integer> a){
        if(node==null)return ;
        addNode(node.left,a);
        a.add(node.data);
        addNode(node.right,a);
    }
    
    List<Integer> mergeArray(ArrayList<Integer> a1,ArrayList<Integer> a2){
        List<Integer> temp=new ArrayList<>();
        int i=0;
        int j=0;
        while(i<a1.size() && j<a2.size()){
            if(a1.get(i)<a2.get(j)){
                temp.add(a1.get(i));
                i++;
            }else {
                temp.add(a2.get(j));
                j++;
            }
        }
        while(i<a1.size()){
            temp.add(a1.get(i));
             i++;
        }
        while(j<a2.size()){
            temp.add(a2.get(j));
            j++;
        }
        return temp;
    }
  
    public List<Integer> merge(Node root1, Node root2) {
        ArrayList<Integer> a1=new ArrayList<>();
        ArrayList<Integer> a2=new ArrayList<>();
        addNode(root1, a1);
        addNode(root2, a2);
        List<Integer> ans=mergeArray(a1,a2);
        return ans;
    }
}