/**
 * Created by 李丹慧 on 2017/3/27.
 */
import java.util.*;

public class TwoStack {
    public int[] twoStack(int[] ope, int n) {
        // write code here
        int[] res;
        int count = 0;
        Stack<Integer> stackPush = new Stack<Integer>();
        Stack<Integer> stackPop = new Stack<Integer>();
        int i = 0;
        while (i < n) {
            if (ope[i] != 0) {
                stackPush.push(ope[i]);//一次性入栈
            } else {
                count++;
            }
            i ++;
        }
        res = new int[count];
        //stackPop此时为空 满足条件2
        while (!stackPush.isEmpty()) {
            stackPop.push(stackPush.pop());//条件1
        }
        i = 0;
        while (count != 0) {
            res[i++] = stackPop.pop();
            count--;
        }
        return res;
    }
}
