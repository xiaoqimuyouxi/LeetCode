package Easy2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225题     用队列来实现栈
 * Created by ly on 2016/12/21.
 */
//100ms
public class MyStack {
    Queue<Integer> stack1 = new LinkedList<>();
    Queue<Integer> stack2 = new LinkedList<>();
    // Push element x onto stack.
    public void push(int x) {
        stack1.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        while(stack1.size() > 1) {
            stack2.offer(stack1.poll());
        }
        stack1.poll();
        Queue tmp = stack1;
        stack1 = stack2;
        stack2 = tmp;
    }

    // Get the top element.
    public int top() {
        while (stack1.size() > 1) {
            stack2.offer(stack1.poll());
        }
        int top = stack1.peek();
        stack2.offer(stack1.poll());

        Queue tmp = stack1;
        stack1 = stack2;
        stack2 = tmp;

        return top;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return stack1.isEmpty();
    }
}
