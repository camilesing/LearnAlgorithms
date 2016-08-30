package Unit1;

import org.junit.Test;


public class DoubleLinkedListTest {
	@Test
	public void  Test() {
		DoubleLinkedList<String> dll = new DoubleLinkedList<String>();
		BidirectionalNode<String > nb1 = new BidirectionalNode<String>(null,"a",null);
		BidirectionalNode<String > nb2 = new BidirectionalNode<String>(null,"b",null);
		BidirectionalNode<String > nb3 = new BidirectionalNode<String>(null,"c",null);
		BidirectionalNode<String > nb4 = new BidirectionalNode<String>(null,"d",null);
		BidirectionalNode<String > nb11 = new BidirectionalNode<String>(null,"aa",null);
		BidirectionalNode<String > nb22 = new BidirectionalNode<String>(null,"bb",null);
		dll.insterAtFirst(nb1);
		dll.insertAtLast(nb2);
		dll.insterAtFirst(nb3);
		dll.insertAtLast(nb4);
//		dll.deleteAtFirst();
//		dll.deleteAtLast();
//		dll.deleteAtFirst();
//		dll.deleteAtLast();
		dll.insertBefore(nb1, nb11);
		dll.insertAfter(nb2, nb22);
		dll.deleteNode(nb3);
		System.out.println("test finished");
	}
}
