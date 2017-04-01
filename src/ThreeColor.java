/**
 * Created by 李丹慧 on 2017/4/1.
 */
import java.util.*;

public class ThreeColor {
    public int[] sortThreeColor(int[] A, int n) {
        // write code here
        int i = 0;
        int zero = -1;
        int two = n;
        while (i < two) {
            if (A[i] == 0) {
                swap(A, ++zero, i++);
            }else if (A[i] == 1) {
                i ++;
            }else {
                swap(A, --two, i);
            }
        }
        return A;
    }
    public void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}