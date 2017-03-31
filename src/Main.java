/**
 * Created by 李丹慧 on 2017/3/27.
 */
//建堆即可 不用堆排序！！！
//建立小根堆 每次弹出堆顶 即为最小元素！！！
import java.util.*;
public class Main {
    public static void main(String args[]) {
        int s[] = sortElement(new int[]{2,1,4,3,6,5,8,7,10,9}, 10, 2);
        /*int s[] = new int[]{2,1,4,3,6,5,8,7,10,9};
        heapSort(s,0, 10);*/
        for(int i = 0; i < 10; i ++) {
            System.out.println(s[i]);
        }
    }
    public static int[] sortElement(int[] A, int n, int k) {
        // write code here
        /*for (int i = 0; i <= n-k; i ++) {
            heapSort(A, i, k);
        }*/
        //头结点不以0开头 则后面的下标全是错的
        for (int i = 0; i <= n-k; i ++) {
            A[i] = makeMinHeap(A, i, k);//弹出堆顶元素
        }
        return A;
    }
    /*不用堆排序
    public static int heapSort(int[] A, int start, int n) {//排成递增数组 所以大根堆
        makeMaxHeap(A, start, n);//建堆后 堆顶最大

        for(int i = n-1; i > start; i --) {
            //swap(A[start], A[i]);
            swap(A, start, i);
            fixDown(A, start, i-start);
        }
        return A[start];
    }*/
    /*建堆即可 所以要递增数组 建立小根堆
    public static void makeMaxHeap(int[] A, int start, int n) {
        for (int i = n/2-1; i >= start; i --) {
            fixDown(A, i, n);
        }
    }
    public static void fixDown(int[] A, int start, int n) {
        int i = start;
        int tmp = A[i];
        int j = i*2 +1;
        while (j < n) {
            if (j+1<n && A[j+1] > A[j]) {
                j ++;
            }
            if (A[j] <= tmp) {
                break;
            }
            //A[j]>A[i]
            A[i] = A[j];//大的上浮
            i = j;
            j = i*2 +1;
        }
        A[i] = tmp;//j出界 i正好
    }*/
    public static int makeMinHeap(int[] A, int start, int n) {//建立小根堆
        for (int i = n/2-1+start; i >= start; i --) {
            fixDown(A, i, n);
        }
        return A[start];//返回堆顶元素
    }
    public static void fixDown(int[] A, int start, int n) {
        int i = start;
        int tmp = A[i];
        int j = i*2 +1;
        while (j < n) {
            if (j+1<n && A[j+1] < A[j]) {
                j ++;
            }
            if (A[j] >= tmp) {
                break;
            }
            //A[j]<A[i]
            A[i] = A[j];//大的上浮
            i = j;
            j = i*2 +1;
        }
        A[i] = tmp;//j出界 i正好
    }
    /*不知道为什么 这个swap不好用 下面那种才好用
    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }*/
    public static void swap(int[] A, int i, int j){
        int tmp = A[i];
        A[i] =A[j];
        A[j] = tmp;
    }
}
