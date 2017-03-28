/**
 * Created by 李丹慧 on 2017/3/28.
 */
import java.util.*;

public class InsertionSort {
    public int[] insertionSort(int[] A, int n) {
        // write code here
        int cur = 0;
        int j = 0;
        for(int i = 1; i < n; i ++) {
            if(A[i] < A[i-1]) {//前i-1个数有序
                cur = A[i];
                j = i;
                while (j!=0 && A[j-1] > cur) {
                    A[j] = A[j-1];
                    j --;
                }
                A[j] = cur;
            }
        }
        return  A;
    }
}