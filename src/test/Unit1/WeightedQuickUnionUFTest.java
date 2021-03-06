package Unit1;

import org.junit.Test;

import Tools.StdIn;
import Tools.StdOut;

public class WeightedQuickUnionUFTest {

	@Test
	public void main(String[] args) {
		int n = StdIn.readInt();
		WeightedQuickUnionUF uf = new WeightedQuickUnionUF(n);
		while (!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if (uf.connected(p, q))
				continue;
			uf.union(p, q);
			StdOut.println(p + " " + q);
		}
		StdOut.println(uf.count() + " components");
	}
}
