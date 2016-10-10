package Unit4;

import Tools.In;
import Tools.StdOut;
import org.junit.*;


public class DigraphTest {

	@Test
    public void Test(String[] args) {
        In in = new In(args[0]);
        Digraph G = new Digraph(in);
        StdOut.println(G);
    }
}
