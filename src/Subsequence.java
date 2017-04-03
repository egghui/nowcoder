/**
 * Created by 李丹慧 on 2017/4/3.
 */
import java.util.*;

public class Subsequence {
    public int shortestSubsequence(int[] A, int n) {
        // write code here
        int max = A[0];
        int min = A[n-1];
        int left = 0;
        int right = n-1;
        for (int i = 1; i < n; i ++) {
            if (A[i] >= max) {
                max = A[i];
            }else {
                right = i;
            }
        }
        for (int i = n-2; i >= 0; i --) {
            if (A[i] <= min) {
                min = A[i];
            }else {
                left = i;
            }
        }
        if (left==0 && right==n-1) {
            return 0;
        }else {
            return right-left+1;
        }
    }
}