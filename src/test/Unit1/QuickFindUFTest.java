package Unit1;

import org.junit.Test;

import Tools.StdIn;
import Tools.StdOut;

public class QuickFindUFTest {

	@Test
	public void main(String[] args) {
		int n = StdIn.readInt();
		QuickFindUF uf = new QuickFindUF(n);
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
