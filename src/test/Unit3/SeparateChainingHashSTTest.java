package Unit3;

import Tools.*;

public class SeparateChainingHashSTTest {
	public void Test() {
		SeparateChainingHashST<String, Integer> st = new SeparateChainingHashST<String, Integer>();
		for (int i = 0; !StdIn.isEmpty(); i++) {
			String key = StdIn.readString();
			st.put(key, i);
		}

		// print keys
		for (String s : st.keys())
			StdOut.println(s + " " + st.get(s));
	}
}
