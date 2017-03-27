/**
 * Created by 李丹慧 on 2017/3/27.
 */
import java.util.*;

public class SlideWindow {
    public int[] slide(int[] arr, int n, int w) {
        // write code here
        if(arr==null|| arr.length < w || w < 1) {
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<Integer>();
        int[] res = new int[n-w+1];
        int index = 0;
        for(int i = 0; i < n; i++) {
            while (!qmax.isEmpty() && arr[qmax.peekLast()]<arr[i]) {
                qmax.pollLast();
            }
            if(qmax.isEmpty() || arr[qmax.peekLast()]>=arr[i]) {
                qmax.addLast(i);
            }
            if(qmax.peekFirst() == i-w) {
                qmax.pollFirst();
            }
            if(i>w-2) {
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return  res;
    }
}