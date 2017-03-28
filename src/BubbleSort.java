/**
 * Created by 李丹慧 on 2017/3/28.
 */
import java.util.*;

public class BubbleSort {
    public int[] bubbleSort(int[] A, int n) {
        // write code here
        int i = 0; int j = 0;
        for(i = 0; i < n-1; i ++) {
            for(j = 1;j < n-i; j ++) {
                if (A[j] < A[j - 1]) {
                    swap(A, j, j - 1);
                }
            }
        }
        return A;
    }
    public void swap(int[] A, int i, int j) {
        int tmp = 0;
        tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}