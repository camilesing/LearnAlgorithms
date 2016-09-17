package Unit1;


/**
 * 双链表的节点
 * @author Camile
 *
 * @param <Item>
 */
public class BidirectionalNode<Item> {

	private BidirectionalNode<Item> previous;
	private Item item;
	private BidirectionalNode<Item> next;
	
	public BidirectionalNode() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BidirectionalNode(BidirectionalNode<Item> previous, Item item, BidirectionalNode<Item> next) {
		super();
		this.previous = previous;
		this.item = item;
		this.next = next;
	}

	public BidirectionalNode<Item> getPrevious() {
		return previous;
	}

	public void setPrevious(BidirectionalNode<Item> previous) {
		this.previous = previous;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public BidirectionalNode<Item> getNext() {
		return next;
	}

	public void setNext(BidirectionalNode<Item> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "BidirectionalNode [previous=" + previous + ", item=" + item + ", next=" + next + "]";
	}
	
}
