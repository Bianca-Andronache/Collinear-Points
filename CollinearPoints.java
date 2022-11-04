/*
  There are 3 sets of points in the plane
    A = {A1, A2,..., An}
    B = {B1, B2,..., Bn}
    C = {C1, C2,..., Cn}
  The points of A are on the equation line y=0
  The points of B are on the equation line y=1
  The points of C are on the equation line y=2

  Determine if there is a pair of collinear points Ai, Bj, Ck
*/

/*Reformulation of the problem:
  There are 3 sets of numbers
    A = {a1, a2,..., an}
    B = {b1, b2,..., bn}
    C = {c1, c2,..., cn}
  Determine if there is a pair of numbers ai, bj, ck with the property: 2bj=ai+ck
*/
package collinearpoints;

public class CollinearPoints {

    public static void main(String[] args) {
        // My example
        int[] A = {-5, 3, 6, 8, 1, -2, 4, 2};
        int[] B = { 4, 8, -5, 9, -3, -1, 10, 2};
        int[] C = {7, -1, 3, 2, 8, -4, -3, 5};
        
        // We assume that there is no pair
        boolean p = false;
        
        // The number of elements of the sets
        int na = A.length;
        int nb = B.length;
        int nc = C.length;
        
        // Create an instance of the MergeSort class to be able to sort the sets
        MergeSort ob = new MergeSort();
        
        // Sort set B
        ob.sort(B, 0, nb - 1);
        System.out.print("B = ");
        ob.printArray(B);
        
        // Sort set C
        ob.sort(C, 0, nc - 1);
        System.out.print("\nC = ");
        ob.printArray(C);
        
        // Create set D, dj = 2 * bj
        // The set B is ordered => D will be ordered
        int[] D = new int[nb];
        for(int i = 0; i < nb; i++)
            D[i] = B[i] * 2;
        System.out.print("\nD = ");
        ob.printArray(D);

        int[] E = new int[nc];

        for(int i = 0; i < na; i++)
        {
            // For each element of A, form the set E, ek = ai + ck
            // The set C is ordered => E will be ordered
            for(int j = 0; j < nc; j++)
                E[j] = A[i] + C[j];

            System.out.print("\nE = ");
            ob.printArray(E);
            
            // Check if E and D have common elements
            int j = 0;
            int k = 0;
            while(j < nc && k < nb)
            {
                if(D[j] == E[k])
                {
                    p = true;
                    break;
                }
                else if(D[j] < E[k])
                    j++;
                    else k++;
            }
            if(p == true) break;
        }
        
        if(p == true)
            System.out.println("There is at least one pair ai, bj, ck with the property 2*bj = ai + ck");
        else
            System.out.println("There is no pair ai, bj, ck with the property 2*bj = ai + ck");
        }
}
