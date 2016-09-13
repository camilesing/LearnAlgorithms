package Unit2;

import org.junit.Test;


public class ShellTest {

	@Test
	public void Test(){
		Shell shell = new Shell();
        String[] a = {"s","h","e","l","l","s","o","r","t","e","x","a","m","e","p","l","e"};
        shell.sort(a);
        shell.show(a);
	}
}
