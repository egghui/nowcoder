/**
 * Created by 李丹慧 on 2017/3/28.
 */
import java.util.*;

public class QuickSort {//挖坑填数&分治法
    public int[] quickSort(int[] A, int n) {
        // write code here
        quicksort(A, 0, n-1);
        return A;
    }
    public int adjustArray(int[] A, int l, int r){
        int i = l;int j = r;
        int x = A[l];
        while (i < j) {
            while (i<j && A[j] >= x) {
                j --;
            }
            if(i < j) {
                A[i++] = A[j];
            }
            while (i<j && A[i] <= x) {
                i ++;
            }
            if(i < j) {
                A[j--] = A[i];
            }
        }
        A[i] = x;
        return  i;
    }
    public void quicksort(int[] A, int l, int r) {
        /*if(l < r) {
            int i = adjustArray(A, l, r);
            quicksort(A, l, i-1);
            quicksort(A, i+1, r);
        }*/
        if(l >= r) {//这种写法和注释掉的写法是一样的 不同的递归出口的写法
            return;
        }
        int i = adjustArray(A, l, r);
        quicksort(A, l, i-1);
        quicksort(A, i+1, r);
    }
}
