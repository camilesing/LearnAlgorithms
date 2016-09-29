package Unit2;

import org.junit.Test;

import Tools.StdIn;
import Tools.StdOut;

public class MaxPQTest {

	@Test
	public void Test() {
		MaxPQ<String> pq = new MaxPQ<String>();
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (!item.equals("-"))
				pq.insert(item);
			else if (!pq.isEmpty())
				StdOut.print(pq.delMax() + " ");
		}
		StdOut.println("(" + pq.size() + " left on pq)");
	}
}
