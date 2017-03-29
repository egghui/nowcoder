/**
 * Created by 李丹慧 on 2017/3/29.
 */
import java.util.*;

public class CountingSort {
    public int[] countingSort(int[] A, int n) {
        // write code here
        int max = A[0];
        int min = A[0];
        int i;
        for (i = 1; i < n; i ++) {
            max = Math.max(max, A[i]);
            min = Math.min(min, A[i]);
        }
        int[] count = new int[max-min+1];//计数
        for (i = 0; i < n; i ++) {
            count[A[i]-min] ++;
        }
        i = 0;
        for (int j = 0; j <= max-min; j ++) {
            while (count[j]!=0) {
                A[i++] = j+min;
                count[j] --;
            }
        }
        return A;
    }
}
