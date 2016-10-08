package Unit4;

import org.junit.*;
import Tools.*;
import Unit4.DepthFirstSearch;
import Unit4.Graph;


public class DepthFirstSearchTest {

	@Test
	public void Test(String[] args){
        In in = new In(args[0]);
        Graph G = new Graph(in);
        int s = Integer.parseInt(args[1]);
        DepthFirstSearch search = new DepthFirstSearch(G, s);
        for (int v = 0; v < G.V(); v++) {
            if (search.marked(v))
                StdOut.print(v + " ");
        }

        StdOut.println();
        if (search.count() != G.V()) StdOut.println("NOT connected");
        else                         StdOut.println("connected");
	}
}
