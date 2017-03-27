/**
 * Created by 李丹慧 on 2017/3/27.
 */
import java.util.*;

public class StackReverse {
    public int[] reverseStack(int[] A, int n) {
        Stack<Integer> stack = new Stack<Integer>();
        // write code here
        for(int i = n-1; i == 0; i --) {
            stack.push(A[i]);
        }
        reverse(stack);
        for(int i=0;i<n;i++) {
            A[i++]=stack.pop();
        }
        return  A;
    }

    public static int getAndRemoveLastElement(Stack<Integer> stack) {
        int result = stack.pop();
        if(stack.isEmpty()){
            return result;
        }else {
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }
    public  static void reverse(Stack<Integer> stack) {
        if(stack.isEmpty()) {
            return;
        }
        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }
}