package Unit1;

import org.junit.*;
import Tools.*;
import Unit1.Stack;

public class StackTest {

	@Test
	public void Test(){
        Stack<String> stack = new Stack<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                stack.push(item);
            else if (!stack.isEmpty())
                StdOut.print(stack.pop() + " ");
        }
        StdOut.println("(" + stack.size() + " left on stack)");
	}
}
