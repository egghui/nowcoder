/**
 * Created by 李丹慧 on 2017/3/29.
 */
import java.util.*;

public class ShellSort {
    public int[] shellSort(int[] A, int n) {
        // write code here
        int gap = n/2;
        while (gap != 0) {
            for(int i = 0; i < gap; i ++) {
                insertionSort(A,n,i,gap);
            }
            gap /= 2;
        }
        return A;
    }
    public void insertionSort(int[] A, int n, int start, int gap) {
        int temp;
        int j = 0;
        for(int i=start+gap; i < n; i ++) {
            temp = A[i];
            j = i-gap;
            while(j>=start && A[i] < A[j]) {
                j -= gap;
            }
            //A[i]>=A[j]
            for(; i>j+gap; i-=gap) {
                A[i] = A[i-gap];
            }
            A[j+gap] = temp;
        }
    }
}
