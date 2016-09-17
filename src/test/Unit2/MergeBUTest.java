package Unit2;

import org.junit.Test;
import Tools.StdIn;

public class MergeBUTest {

	@Test
	public void Test() {
		MergeBU mergeBU = new MergeBU();
		String[] a = { "M", "E", "R", "G", "E", "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E" };
		mergeBU.sort(a);
		mergeBU.show(a);
	}
}
