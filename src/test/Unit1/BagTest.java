package Unit1;

import org.junit.*;
import Unit1.*;
import Tools.*;

public class BagTest {

	@Test
	public void bagAddTest() {
		// Bag<String> bag = new Bag<String>();
		// //添加元素
		// String s1 = "100";
		// String s2 = "101";
		// String s3 = "102";
		// String s4 = "103";
		// bag.add(s1);
		// bag.add(s2);
		// bag.add(s3);
		// bag.add(s4);
		// System.out.println("size of bag = " + bag.size());
		// for (String s : bag) {
		// System.out.println(s);
		// }
		Bag<String> bag = new Bag<String>();

		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			bag.add(item);
		}

		StdOut.println("size of bag = " + bag.size());
		for (String s : bag) {
			StdOut.println(s);
		}
	}
}
