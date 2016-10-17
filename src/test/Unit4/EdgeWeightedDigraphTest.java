package Unit4;

import org.junit.Test;

import Tools.In;
import Tools.StdOut;

public class EdgeWeightedDigraphTest {

	@Test
    public static void main(String[] args) {
        In in = new In(args[0]);
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);
        StdOut.println(G);
    }
}
