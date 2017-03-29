/**
 * Created by 李丹慧 on 2017/3/28.
 */
import java.util.*;

public class HeapSort {
    public int[] heapSort(int[] A, int n) {//最小堆排序完是递减数组 最大堆排序完为递增数组
        // write code here
        makeMaxHeap(A, n);//首先建立最大堆（堆化数组）

        /*首先可以看到堆建好之后堆中第0个数据是堆中最小的数据。
        取出这个数据再执行下堆的删除操作。这样堆中第0个数据又是堆中最小的数据，
        重复上述步骤直至堆中只有一个数据时就直接取出这个数据。
        由于堆也是用数组模拟的，故堆化数组后，第一次将A[0]与A[n - 1]交换，
        再对A[0…n-2]重新恢复堆。第二次将A[0]与A[n – 2]交换，再对A[0…n - 3]重新恢复堆，
        重复这样的操作直到A[0]与A[1]交换。由于每次都是将最小的数据并入到后面的有序区间，
        故操作完成后整个数组就有序了。有点类似于直接选择排序。*/

        for(int i=n-1;i>0;i--){
            swap(A,0,i);
            fixDown(A,0,i);
        }
        return A;
    }
    public void makeMaxHeap(int A[], int n) {
        for(int i=n/2-1; i>=0; i--){
            fixDown(A,i,n);
        }
    }
    public void fixDown(int A[],int i, int n) {//题目要递增数组 故最大堆 n是length
        int j = i*2 +1;
        int tmp = A[i];
        while(j < n) {
            if(j+1<n && A[j+1]>A[j]) {//取两个孩子中较大者 A[n]是刚刚swap下去的数 是已经排完序的数 不在调整范围内 故j+1<n
                j ++;
            }
            if(A[j] <= tmp) {
                break;//调整完毕
            }
            A[i] = A[j];//否则大者上浮
            i = j;
            j = i*2 +1;
        }
        A[i] = tmp;//下沉到它的位置 A[j]>tmp或出界 i是j的父节点 位置正合适
    }

    public void swap(int A[],int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}