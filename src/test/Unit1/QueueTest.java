package Unit1;

import org.junit.*;
import Tools.*;

public class QueueTest {

	@Test
	public void Test() {
		Queue<String> queue = new Queue<String>();
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (!item.equals("-"))
				queue.enqueue(item);
			else if (!queue.isEmpty())
				StdOut.print(queue.dequeue() + " ");
		}
		StdOut.println("(" + queue.size() + " left on queue)");
	}
}
