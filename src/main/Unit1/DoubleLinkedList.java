package Unit1;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author 双链表
 *
 * @param <Item>
 */
public class DoubleLinkedList<Item> implements Iterable<Item> {
	private BidirectionalNode<Item> first, last;
	private int n;

	public DoubleLinkedList() {
		super();
		first = null;
		last = null;
		n = 0;

	}

	public boolean isHadNode(BidirectionalNode node) {

		BidirectionalNode<Item> nowNode = first;
		for (int i = 1; i < n; i++) {
			if (nowNode.equals(node)) {
				return true;

			} else {
				nowNode = nowNode.getNext();
			}
		}
		throw new NoSuchElementException("can't find this node!");
	}

	// private BidirectionalNode<Item> findNode(BidirectionalNode<Item> node) {
	// BidirectionalNode<Item> nowNode = first;
	// for (int i = 1; i < n; i++) {
	// if (nowNode.equals(node)) {
	// return nowNode;
	//
	// } else {
	// nowNode = nowNode.getNext();
	// }
	// }
	//
	// return null;
	// }

	/**
	 * 在表头插入结点
	 * 
	 * @param item
	 */
	public void insterAtFirst(BidirectionalNode<Item> newNode) {
		// 插入需要判断两种情况，一种链表不为空，一种链表为空
		if (first != null) {
			// 不为空，则原first放置到新first的后面
			// change operater
			BidirectionalNode<Item> oldFirst = first;
			// init to firstNode
			first = newNode;
			first.setPrevious(null);
			first.setNext(oldFirst);
			oldFirst.setPrevious(first);
			n++;
		} else if (first == null) {
			// 如果链表为空。那么它就是唯一的结点——首结点是它，尾结点也是它。
			first = newNode;
			last = newNode;
			n++;
		}
	}

	/**
	 * 在表尾插入结点
	 * 
	 * @param item
	 */
	public void insertAtLast(BidirectionalNode<Item> newNode) {
		// 还是要考虑两个情况，链表是否为空
		if (last != null) {
			// TODO 这里还要判断一个元素的情况下...
			BidirectionalNode<Item> oldLast = last;
			last = newNode;
			last.setPrevious(oldLast);
			last.setNext(null);
			oldLast.setNext(last);
			n++;
		} else if (first == null) {
			// 如果链表为空。那么它就是唯一的结点——首结点是它，尾结点也是它。
			first = newNode;
			last = newNode;
			n++;
		}
	}

	/**
	 * 从表头删除结点
	 */
	public void deleteAtFirst() {
		// 如果为空，则不能正常删除，抛出异常
		if (first == null) {
			throw new NoSuchElementException("DoubleLinkedList is Empty");
		}
		if (n == 1) {
			first = null;
			last = null;
		} else {
			BidirectionalNode<Item> oldFirst = first;
			first = oldFirst.getNext();
			first.setPrevious(null);
			// 释放掉oldFirst
			oldFirst = null;
			n--;
		}
	}

	/**
	 * 从表尾删除结点
	 */
	public void deleteAtLast() {
		if (first == null) {
			throw new NoSuchElementException("DoubleLinkedList is Empty");
		}
		if (n == 1) {
			first = null;
			last = null;
		} else {
			BidirectionalNode<Item> oldLast = last;
			last = oldLast.getPrevious();
			last.setNext(null);
			// 释放掉oldLast
			oldLast = null;
			n--;
		}
	}

	/**
	 * 在指定结点前插入
	 * 
	 * @param node
	 * @param newNode
	 */
	public void insertBefore(BidirectionalNode<Item> node, BidirectionalNode<Item> newNode) {
		if (first == null) {
			throw new NoSuchElementException("DoubleLinkedList is Empty");
		}
		// 判断是否有这个节点
		isHadNode(node);
		// 判断：只有一个结点
		if (n == 1) {
			first.setPrevious(newNode);
			newNode.setNext(first);
			n++;
		} else {

			// 处理前面的指向
			newNode.setPrevious(node.getPrevious());
			node.getPrevious().setNext(newNode);
			// 处理后面的指向
			newNode.setNext(node);
			node.setPrevious(newNode);
			n++;
		}
	}

	/**
	 * 在指定结点后插入
	 * 
	 * @param node
	 * @param newNode
	 */
	public void insertAfter(BidirectionalNode<Item> node, BidirectionalNode<Item> newNode) {
		if (first == null) {
			throw new NoSuchElementException("DoubleLinkedList is Empty");
		}
		isHadNode(node);
		// 判断：只有一个结点
		if (n == 1) {
			newNode.setPrevious(first);
			first.setNext(newNode);
			n++;
		} else {
			// 处理后面的指向
			newNode.setNext(node.getNext());
			node.getNext().setPrevious(newNode);
			// 处理前面的指向
			newNode.setPrevious(node);
			node.setNext(newNode);
			n++;
		}
	}

	/**
	 * 删除指定结点
	 * 
	 * @param node
	 */
	public void deleteNode(BidirectionalNode<Item> node) {
		if (first == null) {
			throw new NoSuchElementException("DoubleLinkedList is Empty");
		}
		isHadNode(node);
		if (n == 1) {
			first = null;
			last = null;
		} else {
			if (first == node) {
				first = first.getNext();
				first.setPrevious(null);
			} else if (last == node) {
				last = last.getPrevious();
				last.setNext(null);
			} else {
				node.getPrevious().setNext(node.getNext());
				node.getNext().setPrevious(node.getPrevious());
			}
		}
		n--;
	}

	public boolean isEmpty() {
		return first == null;
	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	private class ListIterator<Item> implements Iterator<Item> {
		private BidirectionalNode<Item> current;

		public ListIterator(BidirectionalNode<Item> first) {
			current = first;
		}

		// 必须被实现的方法1
		public boolean hasNext() {
			return current != null;
		}

		// 必须被实现的方法2
		public void remove() {
			throw new UnsupportedOperationException();
		}

		public Item next() {
			if (!hasNext())
				throw new NoSuchElementException();
			Item item = current.getItem();
			current = current.getNext();
			return item;
		}
	}
}
