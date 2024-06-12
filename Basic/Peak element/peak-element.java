//{ Driver Code Starts
import java.util.*;
import java.io.*;
class PeakElement{
	public static void main(String[] args)throws IOException{
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
		int t=Integer.parseInt(in.readLine().trim());
		while(t-->0){
			int n=Integer.parseInt(in.readLine().trim());
			int[] a=new int[n];
		    int[] tmp=new int[n];
		    String s[]=in.readLine().trim().split(" ");
			for(int i=0;i<n;i++){
				a[i]=Integer.parseInt(s[i]);
				tmp[i] = a[i];
			}
		    
		    int f=0;
			int A=(new Solution()).peakElement(tmp,n);
			
			if(A<0 && A>=n)
			    out.println(0);
			else
			{
    			if(n==1 && A==0)
    			    f=1;
    			else if(A==0 && a[0]>=a[1])
    			    f=1;
    			else if(A==n-1 && a[n-1]>=a[n-2])
    			    f=1;
    			else if(A >= 0 && A < n && a[A] >=a[A+1] && a[A]>= a[A-1])
    			    f=1;
    			else
    			    f=0;
			    out.println(f);
			}
		}
		out.close();
	}
}
// } Driver Code Ends


/*Complete the function below*/


class Solution
{
    // Function to find the peak element
    // arr[]: input array
    // n: size of array arr[]
    public int peakElement(int[] arr, int n)
    {
        // Handling the case where the array has only one element
        if (n == 1) {
            return 0;
        }
        
        // Handling the cases where the first or last element is the peak
        if (arr[0] >= arr[1]) {
            return 0;
        }
        if (arr[n-1] >= arr[n-2]) {
            return n-1;
        }
        
        // Binary search for peak element in the remaining array
        int low = 1;
        int high = n - 2;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            // Check if mid is the peak element
            if (arr[mid] >= arr[mid - 1] && arr[mid] >= arr[mid + 1]) {
                return mid;
            }
            // If the element on the left is greater, then peak lies on the left side
            else if (arr[mid - 1] > arr[mid]) {
                high = mid - 1;
            }
            // If the element on the right is greater, then peak lies on the right side
            else {
                low = mid + 1;
            }
        }
        
        // This line will never be reached if the input array has at least one peak
        return -1;
    }
}