/**
 * Created by 李丹慧 on 2017/3/27.
 */
import java.util.*;

public class TwoStack {
    public int[] twoStack(int[] ope, int n) {
        // write code here
        int[] res = {};
        Stack<Integer> stackPush = new Stack<Integer>();
        Stack<Integer> stackPop = new Stack<Integer>();
        int i = 0;
        int j = 0;
        while(i < n) {
            if(ope[i] != 0) {
                spush(ope,n,stackPush,stackPop,i);
            }else {
                spop(stackPush,stackPop);
            }
        }
        return res;
    }
    public void spush(int[] ope, int n, Stack<Integer> stackPush,Stack<Integer> stackPop, int i) {
        if (i==0||ope[i - 1] != 0) {
            stackPush.push(ope[i]);
        } else {
            while (!stackPop.isEmpty()) {
                stackPush.push(stackPop.pop());
            }
            stackPush.push(ope[i]);
        }
    }
    public int spop(Stack<Integer> stackPush,Stack<Integer> stackPop) {
        if(stackPop.empty()&&stackPush.empty()) {
            throw new RuntimeException("Queue is empty");
        }else if(stackPop.empty()) {
            while (!stackPush.empty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }
}
