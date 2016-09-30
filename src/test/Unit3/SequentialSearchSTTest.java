package Unit3;

import org.junit.Test;
import Tools.*;

public class SequentialSearchSTTest {

	@Test
	public void Test() {
		SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
		for (int i = 0; !StdIn.isEmpty(); i++) {
			String key = StdIn.readString();
			st.put(key, i);
		}
		for (String s : st.keys())
			StdOut.println(s + " " + st.get(s));
	}
}
