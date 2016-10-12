package Unit4;

import Tools.StdOut;

public class EdgeTest {

	@org.junit.Test
    public void Test() {
        Edge e = new Edge(12, 34, 5.67);
        StdOut.println(e);
    }
}
