/**
 * Created by 李丹慧 on 2017/3/28.
 */
import java.util.*;

public class HeapSort {
    public int[] heapSort(int[] A, int n) {//最小堆排序完是递减数组 最大堆排序完为递增数组
        // write code here
        for(int i=n/2; i>=0; i--){
            fixDown(A,i,n);
        }

        for(int i=n-1;i>0;i--){
            swap(A,0,i);
            fixDown(A,0,i);
        }
        return A;
    }
    public void fixDown(int A[],int i, int n) {//题目要递增数组 故最大堆
        int j = i*2 +1;
        int tmp = A[i];
        while(j < n) {
            if(j+1<n && A[j+1]>A[j]) {//取两个孩子中较大者
                j ++;
            }
            if(A[j] <= tmp) {
                break;//调整完毕
            }
            A[i] = A[j];//否则大者上浮
            i = j;
            j = i*2 +1;
        }
        A[i] = tmp;//下沉到它的位置
    }

    public void swap(int A[],int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}