package Unit1;

import org.junit.Test;

import Tools.StdIn;
import Tools.StdOut;

public class QuickUnionUFTest {

	@Test
	public void main(String[] args) {
		int n = StdIn.readInt();
		QuickUnionUF uf = new QuickUnionUF(n);
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
