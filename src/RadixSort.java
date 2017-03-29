/**
 * Created by 李丹慧 on 2017/3/29.
 */
import java.util.*;

public class RadixSort {
    public int[] radixSort(int[] A, int n) {
        // write code here
        //用count和bucket（桶）两个数字模拟桶排序
        int[] count = new int[10];
        int[] bucket = new int[n];
        //int j;
        for (int i = 0; i < 4; i ++) {//个十百千四层
            for (int j = 0; j < 10; j ++ ) {
                count[j] = 0;//清零上一次的结果
            }
            for (int j = 0; j < n; j ++) {
                count[getNum(A[j],i)] ++;
            }
            for (int k = 1; k < 10; k ++) {
                count[k] += count[k-1];//以上两个for循环计算出在bucket数组中的位置
            }
            for (int m = n-1; m >= 0; m --) {//放入桶中
                bucket[count[getNum(A[m], i)]-1] = A[m] ;
                count[getNum(A[m], i)] --;
            }
            for (int j = 0; j < n; j ++) {
                A[j] = bucket[j] ;
            }
        }
        return A;
    }
    public int getNum(int num, int i) {
        int[] bit = {1, 10, 100, 1000};
        return (num/bit[i])%10;
    }
}