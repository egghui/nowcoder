/**
 * Created by 李丹慧 on 2017/3/30.
 */
import java.util.*;

public class Merge {
    public int[] mergeAB(int[] A, int[] B, int n, int m) {
        // write code here
        int k = n+m-1;
        int i = n-1;
        int j = m-1;
        while (i>=0 && j>=0) {
            if (A[i] >= B[j]) {
                A[k--] = A[i--];
            }else {
                A[k--] = B[j--];
            
        }
        while (i>=0) {
            A[k--] = A[i--];
        }
        while (j>=0) {
            A[k--] = B[j--];
        }
        return A;
    }
}
