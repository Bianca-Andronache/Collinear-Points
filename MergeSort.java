package collinearpoints;

public class MergeSort {
    
    // First subarray is from l to m (m = middle of the array)
    // Second subarray is form m+1 to r
    public void mergeSubarrays(int S[], int l, int m, int r){
        
        // The sizes of the two subarrays
        int n1 = m - l + 1;
        int n2 = r - m;
        
        // Create two temp arrays
        int[] L1 = new int[n1];
        int[] L2 = new int[n2];
        
        // Copy data to temp arrays
        for(int i = 0; i < n1; i++)
            L1[i] = S[l + i];
        for(int j = 0; j < n2; j++)
            L2[j] = S[m + 1 + j];
        
        // Now, merge the temp arrays
        
        // Indexes of the first and second subarrays
        int i = 0, j = 0;
        
        // Index of the original array
        int k = l;
        
        // Do until we reach the end of one of the subarrays
        while(i < n1 && j < n2){
            
            // The smaller element is added
            // And the index of the subarray to which it belonged increases
            if(L1[i] <= L2[j])
            {
                S[k] = L1[i];
                i++;
            }
            else
            {
                S[k] = L2[j];
                j++;
            }
            
            // Then we move to the next position in the array
            k++;
        }
        
        // Copy remaining elements of L1[] if any
        while(i < n1){
            S[k] = L1[i];
            i++;
            k++;
        }
        
        // Copy remaining elements of L2[] if any
        while(j < n2){
            S[k] = L2[j];
            j++;
            k++;
        }
    }
    
    // Sort S[] using mergeSubarrays() and divide et impera
    public void sort(int S[], int l, int r){
        
        // While there are more than one element in the array
        if(l < r)
        {
            // Find the middle of the current array
            int m = l + (r - l) / 2;
            
            // Sort first and second halves
            sort(S, l, m);
            sort(S, m + 1, r);
            
            // Merge the sorted halves
            mergeSubarrays(S, l, m, r);
        }
    }
    
    // Function used to print the array
    public void printArray(int S[]){
        int n = S.length;
        for(int i = 0; i < n; i++)
            System.out.print(S[i] + " ");
        System.out.println();
    }
}
