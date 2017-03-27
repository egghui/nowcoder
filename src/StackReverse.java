/**
 * Created by 李丹慧 on 2017/3/27.
 */
import java.util.*;

public class StackReverse {
    public int[] reverseStack(int[] A, int n) {
        // write code here
        if(A==null || n == 1) {
            return A;
        }
        int i =  A[0];
        for(int j = 0; j < n-1; j ++) {
            A[j] = A[j+1];
        }
        reverseStack(A,n-1);
        A[n-1] = i;
        return A;
    }
}