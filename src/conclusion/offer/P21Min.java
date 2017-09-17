package conclusion.offer;

import java.util.Stack;

/**
 * Created by ly on 2017/9/14.
 */
public class P21Min {
    Stack<Integer> mainStack = new Stack<>();
    Stack<Integer> stack = new Stack<>();

    public void push(int node) {
        mainStack.push(node);
        if(stack.isEmpty() || node < stack.peek()) {
            stack.push(node);
        }
        else stack.push(stack.peek());
    }

    public void pop() {
        if(!mainStack.isEmpty() && !stack.isEmpty()) {
            mainStack.pop();
            stack.pop();
        }
    }

    public int top() {
        if(!mainStack.isEmpty()) {
            return mainStack.peek();
        }
        else return 0;
    }

    public int min() {
        if(!stack.isEmpty()) {
            return stack.peek();
        }
        else return 0;
    }
}
