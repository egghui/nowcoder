/**
 * Created by 李丹慧 on 2017/3/27.
 */
import java.util.*;

public class MaxTree {
    public int[] buildMaxTree(int[] A, int n) {
        // write code here
        HashMap<Integer,Integer> lBig = new HashMap<Integer,Integer>();//value存下标
        HashMap<Integer,Integer> rBig = new HashMap<Integer,Integer>();
        Stack<Integer> stack = new Stack<Integer>();//栈里也存下标
        int cur = 0;
        int[] res = new int[n];//返回结果
        for(int i = 0; i < n; i ++) {
            if(stack.isEmpty() || A[stack.peek()]>A[i]) {
                stack.push(i);
            }else {
                while (!stack.isEmpty() && A[stack.peek()]<A[i]) {
                    cur = stack.pop();
                    rBig.put(cur, i);
                    if(!stack.isEmpty()) {//左边最大是null的情况不用写 本来就是
                        lBig.put(cur, stack.peek());
                    }
                }
                stack.push(i);//调整完入栈 可和if情况合写
            }
        }
        while (!stack.isEmpty()) {//遍历完数组后 栈不为空 继续处理栈
            cur = stack.pop();
            if(stack.isEmpty()) {
                break;//最后一个节点 根节点 最大值
            }else {//rBig均为null
                lBig.put(cur, stack.peek());
            }
        }
        //最后一个 根节点 lBig和rBig都是null 不用写
        for(int i =0; i < n; i ++) {
            if(lBig.get(i)==null && rBig.get(i)==null) {
                res[i] = -1;
            }else if(lBig.get(i)==null) {
                res[i] = rBig.get(i);
            }else if(rBig.get(i)==null) {
                res[i] = lBig.get(i);
            }else {
                res[i] = A[lBig.get(i)]<A[rBig.get(i)]?lBig.get(i):rBig.get(i);
            }
        }
        return res;
    }
}
