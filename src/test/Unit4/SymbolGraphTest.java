package Unit4;

import org.junit.Test;

import Tools.StdIn;
import Tools.StdOut;

public class SymbolGraphTest {

	/**
	 * 间隔度数测试
	 */
	@Test
	public void Test(String[]args){
        String filename  = args[0];
        String delimiter = args[1];
        SymbolGraph sg = new SymbolGraph(filename, delimiter);
        Graph graph = sg.graph();
        while (StdIn.hasNextLine()) {
            String source = StdIn.readLine();
            if (sg.contains(source)) {
                int s = sg.indexOf(source);
                for (int v : graph.adj(s)) {
                    StdOut.println("   " + sg.nameOf(v));
                }
            }
            else {
                StdOut.println("input not contain '" + source + "'");
            }
        }
	}
}
