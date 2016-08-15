package Unit1;

import org.junit.Test;
import Tools.*;
import Unit1.ResizingArrayStack;

public class ResizingArrayStackTest {

	@Test
	public void raStackTest() {
		ResizingArrayStack<String> stack = new ResizingArrayStack<String>();
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
