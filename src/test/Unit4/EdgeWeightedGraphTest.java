package Unit4;

import org.junit.Test;

import Tools.In;
import Tools.StdOut;

public class EdgeWeightedGraphTest {

	@Test
	public  void Test(String[] args) {
		In in = new In(args[0]);
		EdgeWeightedGraph G = new EdgeWeightedGraph(in);
		StdOut.println(G);
	}
}
