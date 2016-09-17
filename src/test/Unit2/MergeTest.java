package Unit2;

public class MergeTest {

	@org.junit.Test
	public void Test() {
		Merge merge = new Merge();
		String[] a = { "M", "E", "R", "G", "E", "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E" };
		merge.sort(a);
		merge.show(a);

	}
}
