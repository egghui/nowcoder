/**
 * Created by 李丹慧 on 2017/3/31.
 */
import java.util.*;

public class Checker {
    public boolean checkDuplicate(int[] a, int n) {
        // write code here
        makeMaxTree(a, n);
        for (int i = n-1; i >= 0; i --) {
            swap(a, i, 0);
            heapAdjust(a, i, 0);
        }
        for (int i = 0;i < n-1; i ++) {
            if (a[i] == a[i+1]) {
                return true;
            }
        }
        return false;
    }
    public void makeMaxTree(int[] a, int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapAdjust(a, n, i);
        }
    }
    public void heapAdjust(int[] a, int n, int i) {
        int tmp = a[i];
        int j = i * 2 + 1;
        while (j < n) {
            if (j + 1 < n && a[j + 1] > a[j]) {
                j++;
            }
            if (a[j] <= tmp) {
                break;
            }
            a[i] = a[j];
            i = j;
            j = i * 2 + 1;
        }
        a[i] = tmp;
    }
    public void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}