package Unit2;

import Tools.StdIn;
import Tools.StdOut;
import Tools.StdRandom;

public class QuickSortTest {

	@org.junit.Test
	public void Test() {

		String[] a = {"Q","U","I","C","K","S","O","R","T","E","X","A","M","P","L","E"};
		QuickSort quickSort = new QuickSort();
		quickSort.sort(a);
		quickSort.show(a);
		assert quickSort.isSorted(a);

		// shuffle
		StdRandom.shuffle(a);

		// display results again using select
		StdOut.println();
		for (int i = 0; i < a.length; i++) {
			String ith = (String) quickSort.select(a, i);
			StdOut.println(ith);
		}
	}
}
