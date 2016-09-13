package Unit2;

import Tools.StdIn;
import org.junit.*;

public class SelectionTest {

	@Test
	public void Test(){
		Selection selection = new Selection();
		String[] a = {"s","o","r","t","e","x","a","m","e","p","l","e"};
        selection.sort(a);
        selection.show(a);
	}
}
