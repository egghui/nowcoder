/**
 * Created by 李丹慧 on 2017/3/27.
 */
import java.util.*;

public class StackReverse {
    public int[] reverseStack(int[] A, int n) {
        // write code here
        if(A==null)
            return null;
        for(int i=0;i*2<n;i++){
            int tmp = A[i];
            A[i] = A[n-1-i];
            A[n-1-i] = tmp;
        }
        return A;
    }
}