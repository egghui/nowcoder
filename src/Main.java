/**
 * Created by 李丹慧 on 2017/3/27.
 */
import java.util.*;
public class Main {
    public static void main(String args[]) {
        int s[] = radixSort(new int[]{54, 35, 48, 36, 27, 12, 44, 44}, 8);
    }
    public static int[] radixSort(int[] A, int n) {
        // write code here
        //用count和bucket（桶）两个数字模拟桶排序
        int[] count = new int[10];
        int[] bucket = new int[n];
        int j;
        for (int i = 0; i < 4; i ++) {//个十百千四层
            for (j = 0; j < n; j ++ ) {
                count[j] = 0;//清零上一次的结果
            }
            for (j = 0; j < n; j ++) {
                count[getNum(A[j],i)] ++;
            }
            for (j = 1; j < 10; j ++) {
                count[j] += count[j-1];//以上两个for循环计算出在bucket数组中的位置
            }
            for (j = n-1; j >= 0; j --) {//放入桶中
                bucket[count[getNum(A[j], i)]-1] = A[j] ;
                count[getNum(A[j], i)] --;
            }
            for (j = 0; j < n; j ++) {
                A[j] = bucket[j] ;
            }
        }
        return A;
    }
    public static int getNum(int num, int i) {
        int[] bit = {1, 10, 100, 1000};
        return (num/bit[i])%10;
    }
}
