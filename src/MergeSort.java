/**
 * Created by 李丹慧 on 2017/3/28.
 */
import java.util.*;

public class MergeSort {
    public int[] mergeSort(int[] A, int n) {
        // write code here
        int[] tmp = new int[n];
        mergesort(A, 0,n-1,tmp);
        return A;
    }
    public void mergesort(int[] A,int first, int last, int[] tmp) {//归并 无返回
        if(first < last) {//出口 一直找到单个元素 单个元素即有序 然后1并2 2并4 数就是对的了 哪怕是n==6或n==13等情况
            int mid = (first+last)/2;
            mergesort(A, first, mid, tmp);
            mergesort(A, mid+1,last,tmp);
            mergeArray(A, first, mid, last, tmp);
        }
    }
    //合并 先合并到临时数组 再转入原数组A
    public void mergeArray(int[] A, int first, int mid, int last, int tmp[]) {
        int i = first;int j = mid+1;
        int k = 0;
        while(i<=mid && j<=last) {
            if(A[i] <= A[j]) {
                tmp[k++] = A[i++];
            }else {
                tmp[k++] = A[j++];
            }
        }
        while(i<=mid) {
            tmp[k++] = A[i++];
        }
        while(j<=last) {
            tmp[k++] = A[j++];
        }
        for(i = 0; i < k; i ++) {
            A[first+i] = tmp[i];
        }
    }
}
