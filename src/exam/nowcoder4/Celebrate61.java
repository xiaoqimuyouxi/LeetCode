package exam.nowcoder4;

import java.util.*;

/**
 * //这个很简单啊！怎么样身高差最小呢？就是两身高差不多的人站一起咯，小时候站队 老师总让
 //矮的站中间高的站两边，就是这个道理，如 9 8 7 6 6 7 8 9然后9和9再拉手不就可以了吗 ！所以
 //将数据输入一个数组如【8 9 7 6 5 4 3 2】然后排序【2 3 4 5 6 7 8 9】然后遍历数组进入
 //一个队列一个栈 现规定，索引为0,2,4，，，的依次进入队列Q1，索引为1,3,5，，，，的依次进入//栈S1，就形成一个队列2 4 6 8 （队列尾为8）和
 一个栈3 5 7 9（栈顶为9） 。然后出栈9 7 5 3
 //依次进入队列尾 形成 2 4 6 8 9 7 5 3 就排队成功，2和3拉手就成圈，求每个元素与挨着的
 //距离就可以了
 *
 * Created by ly on 2017/8/8.
 */
public class Celebrate61 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        Arrays.sort(arr);   //先对数组进行排序
        //用LinkedList来实现队列的先进先出功能
        LinkedList<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if((i&1) == 0) {
                queue.addLast(arr[i]);
            }
            else stack.push(arr[i]);
        }

        int size = stack.size();
        for(int i = 0; i < size; i++) {
            queue.addLast(stack.pop());
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i < queue.size(); i++) {
            int inter = 0;
            if(i == 0) {
                inter = Math.abs(queue.get(n-1) - queue.get(0));
            }
            else {
                inter = Math.abs(queue.get(i) - queue.get(i-1));
            }
            if(max < inter) {
                max = inter;
            }
        }
        System.out.println(max);
    }
}
