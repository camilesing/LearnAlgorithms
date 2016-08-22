package Unit1;

import java.nio.file.NotDirectoryException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author Administrator
 *
 * @param <Item>
 */
/**
 * @author Administrator
 *
 * @param <Item>
 */
public class DoubleLinkedList<Item> implements Iterable<Item> {
	private Node<Item> first;
	private Node<Item> last;
	private int n;

	private static class Node<Item> {
		private Node<Item> previous;
		private Item item;
		private Node<Item> next;
	}

	public void isHadNode(Node node) {

		Node<Item> nowNode = first;
		for (int i = 1; i == n; i++) {
			if (nowNode.equals(node)) {
				break;
			} else {
				nowNode = first.next;
			}
		}
		throw new NoSuchElementException("can't find this node!");
	}

	// 在表头插入结点
	public void insterAtFirst(Item item) {
		// 插入需要判断两种情况，一种链表不为空，一种链表为空
		if (first != null) {
			// 不为空，则原first放置到新first的后面
			// change operater
			Node<Item> oldFirst = first;
			// init to firstNode
			first.previous = null;
			first.item = item;
			first.next = oldFirst;
			// 完成链接
			oldFirst.previous = first;
			n++;
		} else if (first == null) {
			// 如果链表为空。那么它就是唯一的结点——首结点是它，尾结点也是它。
			first.previous = null;
			first.item = item;
			first.next = null;
			last.previous = null;
			last.item = item;
			last.next = null;
			n++;
		}
	}

	// 在表尾插入结点
	public void insertAtLast(Item item) {
		// 还是要考虑两个情况，链表是否为空
		if (last != null) {
			Node<Item> oldLast = last;
			last.previous = oldLast;
			last.item = item;
			last.next = null;
			oldLast.next = last;
			n++;
		} else if (first == null) {
			// 如果链表为空。那么它就是唯一的结点——首结点是它，尾结点也是它。
			first.previous = null;
			first.item = item;
			first.next = null;
			last.previous = null;
			last.item = item;
			last.next = null;
			n++;
		}
	}

	// 从表头删除结点
	public void deleteAtFirst() {
		// 如果为空，则不能正常删除，抛出异常
		if (first == null) {
			throw new NoSuchElementException("DoubleLinkedList is Empty");
		}
		if (n == 1) {
			first = null;
			last = null;
		} else {
			Node<Item> oldFirst = first;
			first = oldFirst.next;
			first.previous = null;
			// 释放掉oldFirst
			oldFirst = null;
			n--;
		}
	}

	// 从表尾删除结点
	public void deleteAtLast() {
		if (first == null) {
			throw new NoSuchElementException("DoubleLinkedList is Empty");
		}
		if (n == 1) {
			first = null;
			last = null;
		} else {
			Node<Item> oldLast = last;
			last = oldLast.previous;
			last.next = null;
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
	public void insertBefore(Node<Item> node, Node<Item> newNode) {
		if (first == null) {
			throw new NoSuchElementException("DoubleLinkedList is Empty");
		}
		isHadNode(node);
		// 判断：只有一个结点
		if (n==1){
			first.previous = newNode;
			newNode.next = first;
		}

		// 处理前面的指向
		newNode.previous = node.previous;
		node.previous.next = newNode;
		// 处理后面的指向
		newNode.next = node;
		node.previous = newNode;
		n++;
	}

	/**
	 * 在指定结点后插入
	 * 
	 * @param node
	 * @param newNode
	 */
	public void insertAfter(Node<Item> node, Node<Item> newNode) {
		if (first == null) {
			throw new NoSuchElementException("DoubleLinkedList is Empty");
		}
		isHadNode(node);
		// 判断：只有一个结点
		if (n==1){
			newNode.previous = first;
			first.next = newNode;
		}
		// 处理后面的指向
		newNode.next = node.next;
		node.next.previous = newNode;
		// 处理前面的指向
		newNode.previous = node;
		node.next = newNode;
		n++;
	}

	/**
	 * 删除指定结点
	 * 
	 * @param node
	 */
	public void deleteNode(Node<Item> node) {
		if (first == null) {
			throw new NoSuchElementException("DoubleLinkedList is Empty");
		}
		isHadNode(node);
		node.previous.next = node.next;
		node.next.previous = node.previous;
		node = null;
	}

	/**
	 * 从指定结点前删除
	 * 
	 * @param node
	 */
	public void deleteBefore(Node<Item> node) {
		if (first == null) {
			throw new NoSuchElementException("DoubleLinkedList is Empty");
		}
		isHadNode(node);
		// 前一个节点指向前前一个
		node.previous = node.previous.previous;
		node.previous.next = node;
		n--;
	}

	/**
	 * 从指定结点后删除
	 * 
	 * @param node
	 */
	public void deleteAfter(Node<Item> node) {
		if (first == null) {
			throw new NoSuchElementException("DoubleLinkedList is Empty");
		}
		isHadNode(node);
		node.next = node.next.next;
		node.next.previous = node;
		n--;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		for (Item item : this)
			s.append(item + " ");
		return s.toString();
	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	private class ListIterator<Item> implements Iterator<Item> {
		private Node<Item> current;

		public ListIterator(Node<Item> first) {
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
			Item item = current.item;
			current = current.next;
			return item;
		}
	}
}
