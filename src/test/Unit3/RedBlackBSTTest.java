package Unit3;

import org.junit.Test;

import Tools.StdIn;
import Tools.StdOut;

public class RedBlackBSTTest {

	@Test
	public void Test(){
        RedBlackBST<String, Integer> st = new RedBlackBST<String, Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
        StdOut.println();
	}
}
