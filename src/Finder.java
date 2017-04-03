/**
 * Created by 李丹慧 on 2017/4/3.
 */
import java.util.*;

public class Finder {
    public boolean findX(int[][] mat, int n, int m, int x) {
        // write code here
        int i = 0;
        int j = m-1;
        //int cur = mat[0][m-1];
        while (i<=n-1 && j>=0) {
            if (mat[i][j] < x) {
                i ++;
            }else if (mat[i][j] > x) {
                j --;
            }else {
                return true;
            }
        }
        return false;
    }
}
