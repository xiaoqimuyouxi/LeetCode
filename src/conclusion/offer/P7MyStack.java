package conclusion.offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用两个队列实现一个栈
 *
 * 思路：链接：https://www.nowcoder.com/questionTerminal/54275ddae22f475981afa2244dd448c6
 来源：牛客网

 <分析>：


 入栈：将元素进队列A


 出栈：判断队列A中元素的个数是否为1，如果等于1，则出队列，否则将队列A中的元素

   依次出队列并放入队列B，直到队列A中的元素留下一个，然后队列A出队列，再把

   队列B中的元素出队列以此放入队列A中。
 * Created by ly on 2017/6/27.
 */
public class P7MyStack {
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    public void push(int node) {
        queue1.add(node);
    }

    public int pop() {
        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }
        int res = queue1.poll();
        Queue<Integer> tmp = queue1;
        queue1 = queue2;
        queue2 = tmp;
        return res;
    }

}
