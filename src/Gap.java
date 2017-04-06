/**
 * Created by 李丹慧 on 2017/4/3.
 */
import java.util.*;

public class Gap {
    public int maxGap(int[] A, int n) {
        // write code here
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i ++) {
            max = A[i]>max ? A[i] : max;
            min = A[i]<min ? A[i] : min;
        }
        if (max==min) {
            return 0;
        }
        boolean[] hasNum = new boolean[n+1];//桶中有无元素
        int[] maxs = new int[n+1];//每个桶中最大的元素
        int[] mins = new int[n+1];//每个桶中最小的元素

        //当前桶中最小元素-前一个桶中最大 依次比较这种值 最大的为所求

        //入桶
        for (int i = 0; i < n; i ++) {
            int bit = bucket(A[i], n, max, min);
            maxs[bit] = hasNum[bit] ? Math.max(maxs[bit], A[i]) : A[i];
            mins[bit] = hasNum[bit] ? Math.min(mins[bit], A[i]) : A[i];
            hasNum[bit] = true;//注意最后再写这个 写于上两行之后
        }

        int lastMax = 0;
        int i = 0;
        int res = 0;
        while (i <= n) {//找出第一个lastMax
            if (hasNum[i]) {
                lastMax = maxs[i++];
                break;
            }
            i ++;
        }
        for (; i <=n; i ++) {//顺着上个循环接着找
            if (hasNum[i]) {
                res = res>mins[i]-lastMax ? res : mins[i]-lastMax;
                lastMax = maxs[i];
            }
        }
        return res;
    }
    //用来计算桶号 据传用long防止乘法越界
    public int bucket(int num, int len, int max, int min) {
        return (int)(num-min)*len/(max-min);//下标是int 记得强制类型转换
    }
}