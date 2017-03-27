/**
 * Created by 李丹慧 on 2017/3/27.
 */
import java.util.*;

public class TwoStacks {
    public ArrayList<Integer> twoStacksSort(int[] numbers) {
        Scanner s = new Scanner(System.in);
        for(int j = 0; j<6;j++) {
            numbers[j++] = s.nextInt();
        }
        // write code here
        Stack<Integer> help = new Stack<Integer>();
        int i = 0;//数组numbers模拟栈stackNum ++出栈 --进栈
        int n = numbers.length;
        int tmp = 0;
        while(i < n) {
            if(help.isEmpty() || numbers[i]<=help.peek()) {//stackNum出栈 help进栈
                help.push(numbers[i++]);
            }else {
                tmp = numbers[i];
                while (!help.isEmpty()&&help.peek() < tmp  ) {
                    numbers[i--] = help.pop();
                }
                help.push(tmp);
                i ++;
            }
        }//help从小到大 如stackNum是真栈 翻一下自然从大到小

        for(i = n-1; i>=0; i--) {
            numbers[i] = help.pop();//入栈
        }
        ArrayList<Integer> list = new ArrayList<Integer>();//转换成要求的返回类型
        for(i = 0; i<n; i++) {
            list.add(numbers[i]);
        }
        return list;
    }
}
