package Unit1;

import org.junit.*;
import Unit1.Stack;
import Tools.*;

public class StackTest {

	@Test
	public void Test() {

		Stack<String> stack = new Stack<String>();
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (item.equals("find")) {
				stack.find("3");
			}
			else if (item.equals("remove")) {
				stack.remove("1");
			}
			else if (item.equals("del")) {
				stack.delete(3);
			}
			else if (!item.equals("-")) {
				stack.push(item);
			} 
			else if (!stack.isEmpty()) {
				StdOut.println(stack.pop() + " ");
			}

		}
		StdOut.println("(" + stack.size() + " left on stack)");
	}
}
