/**
 * Created by 李丹慧 on 2017/4/6.
 */
import java.util.*;

public class Transform {
    public boolean chkTransform(String A, int lena, String B, int lenb) {
        // write code here
        if (lena != lenb) {
            return false;
        }
        int[] stra = new int[65536];
        int[] strb = new int[65536];

        toStr(stra, A, lena);
        toStr(strb, B, lenb);

        for (int i = 0; i < 65536; i ++) {
            if (stra[i] != strb[i]) {
                return false;
            }
        }
        return true;
    }

    public void toStr(int[] strTo, String str, int len) {
        for (int i = 0; i < len; i ++) {
            char c = str.charAt(i);
            strTo[c] ++;
        }
    }
}