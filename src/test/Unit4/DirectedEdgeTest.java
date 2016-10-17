package Unit4;

import Tools.StdOut;

public class DirectedEdgeTest {

	@org.junit.Test
    public  void Test(String[] args) {
        DirectedEdge e = new DirectedEdge(12, 34, 5.67);
        StdOut.println(e);
    }
}
