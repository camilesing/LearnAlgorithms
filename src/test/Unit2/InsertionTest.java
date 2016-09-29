package Unit2;

import org.junit.Test;

import Tools.StdIn;

public class InsertionTest {

	@Test
	public void Test() {
		Insertion insertion = new Insertion();
		String[] a = { "s", "o", "r", "t", "e", "x", "a", "m", "e", "p", "l", "e" };
		insertion.sort(a);
		insertion.show(a);
	}
}
