package Easy2;

import java.util.Stack;

/**
 * 20题
 * 正反括号匹配问题
 * @author ly
 *
 */
public class ValidParentheses {
	/**
	 * 5ms
	 * 解题思路：
	 * 		对字符串s中的每一个字符tmp，如果是左括号就压入栈中，如果是右括号就检查栈是否为空，如果为空，
	 * 返回false，不为空时再将栈顶元素取出与右括号匹配，匹配成功则删除栈顶元素，不成功则返回false;接着再执行
	 * 下一个元素。。。。。。最后匹配完成后仍然需要判断栈是否为空，如果不为空则返回false
	 * @param s
	 * @return
	 */
	public boolean isValid(String s) {
        if(s.length() == 0 || s.length()%2 != 0)
            return false;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
        	char tmp = s.charAt(i);
        	if(tmp != ')' && tmp != ']' && tmp != '}')
        		stack.push(tmp);
        	if(tmp == ')') {
        		if(stack.isEmpty())
        			return false;
        		else {
        			char s1 = stack.peek();
        			if(s1 == '(')
        				stack.pop();
        			else
        				return false;
        		}
        	}
        	if(tmp == ']') {
        		if(stack.isEmpty())
        			return false;
        		else {
        			char s1 = stack.peek();
        			if(s1 == '[')
        				stack.pop();
        			else
        				return false;
        		}
        	}
        	if(tmp == '}') {
        		if(stack.isEmpty())
        			return false;
        		else {
        			char s1 = stack.peek();
        			if(s1 == '{')
        				stack.pop();
        			else
        				return false;
        		}
        	}
        }
        if(stack.isEmpty())
        	return true;
        else
        	return false;
    }

	public static void main(String[] args) {
		ValidParentheses v = new ValidParentheses();
		System.out.println(v.isValid("{([]"));
	}
}
