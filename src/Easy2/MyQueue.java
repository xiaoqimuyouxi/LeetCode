package Easy2;

import java.util.Stack;

/**
 * 232题     Implement Queue using Stacks    145ms
 * 用栈实现队列
 * 如果队列中元素是1,2,3,4，那么在栈中存储的顺序是4,3,2,1
 * 所以在push时需要用到一个辅助栈tmp
 * Created by ly on 2016/12/9.
 */
public class MyQueue {
    private Stack<Integer> s = new Stack<>();

    // Push element x to the back of queue.
    public void push(int x) {
        Stack<Integer> tmp = new Stack<>();
        while(!s.isEmpty()) {
            tmp.push(s.pop());
        }
        tmp.push(x);
        while(!tmp.isEmpty()) {
            s.push(tmp.pop());
        }
    }

    // Removes the element from in front of queue.
    public void pop() {
        s.pop();
    }

    // Get the front element.
    public int peek() {
        return s.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return s.isEmpty();
    }

    //91ms
    class MyQueue1 {
        private Stack<Integer> queue = new Stack<>();

        // Push element x to the back of queue.
        public void push(int x) {
            queue.push(x);
        }

        // Removes the element from in front of queue.
        public void pop() {
            queue.remove(0);
        }

        // Get the front element.
        public int peek() {
            return queue.firstElement();
        }

        // Return whether the queue is empty.
        public boolean empty() {
            return queue.isEmpty();
        }
    }

    //96ms
    class MyQueue2 {
        private Stack<Integer> s1 = new Stack<>();
        private Stack<Integer> s2 = new Stack<>();

        // Push element x to the back of queue.
        public void push(int x) {
            s1.push(x);
        }

        // Removes the element from in front of queue.
        public void pop() {
            peek();
            s2.pop();
        }

        // Get the front element.
        public int peek() {
            if(s2.isEmpty()) {
                while(!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
            return s2.peek();
        }

        // Return whether the queue is empty.
        public boolean empty() {
            return s1.isEmpty() && s2.isEmpty();
        }
    }
}
