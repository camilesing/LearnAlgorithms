import org.junit.Test;

import Tools.*;
import Unit4.Graph;

public class Unit4 {

	@Test
	public void Test(String []args){
        In in = new In(args[0]);
        Graph G = new Graph(in);
        StdOut.println(G);
	}
}
