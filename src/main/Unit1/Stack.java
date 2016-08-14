package Unit1;

import java.util.Iterator;
import java.util.NoSuchElementException;

import Tools.StdOut;

public class Stack<Item> implements Iterable<Item> {
	private Node<Item> first; // top of stack
	private int n; // size of the stack

	// helper linked list class
	private static class Node<Item> {
		private Item item;
		private Node<Item> next;
	}

	/**
	 * Initializes an empty stack.
	 */
	public Stack() {
		first = null;
		n = 0;
	}

	/**
	 * Returns true if this stack is empty.
	 *
	 * @return true if this stack is empty; false otherwise
	 */
	public boolean isEmpty() {
		return first == null;
	}

	/**
	 * Returns the number of items in this stack.
	 *
	 * @return the number of items in this stack
	 */
	public int size() {
		return n;
	}

	/**
	 * Adds the item to this stack.
	 *
	 * @param item
	 *            the item to add
	 */
	public void push(Item item) {
		Node<Item> oldfirst = first;
		first = new Node<Item>();
		first.item = item;
		first.next = oldfirst;
		n++;
	}

	/**
	 * Removes and returns the item most recently added to this stack.
	 *
	 * @return the item most recently added
	 * @throws NoSuchElementException
	 *             if this stack is empty
	 */
	public Item pop() {
		if (isEmpty())
			throw new NoSuchElementException("Stack underflow");
		Item item = first.item; // save item to return
		first = first.next; // delete first node
		n--;
		return item; // return the saved item
	}

	/**
	 * Returns (but does not remove) the item most recently added to this stack.
	 *
	 * @return the item most recently added to this stack
	 * @throws NoSuchElementException
	 *             if this stack is empty
	 */
	public Item peek() {
		if (isEmpty())
			throw new NoSuchElementException("Stack underflow");
		return first.item;
	}

	/**
	 * Returns a string representation of this stack.
	 *
	 * @return the sequence of items in this stack in LIFO order, separated by
	 *         spaces
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (Item item : this)
			s.append(item + " ");
		return s.toString();
	}

	// 1.3.20——尝试制作：传入数字k，删除链表的第K个元素。那么肯定是栈顶开始计算
	public void delete(int k) {

		// 不允许大于n的值
		if (k <= n) {
			Node<Item> nowNextNode = first;
			// 要第几个就next到第几个的上一个
			for (int i = 1; (k-1) != i; i++) {
				nowNextNode = nowNextNode.next;
			}
			// 删除节点
			Node<Item> needLinePoint = nowNextNode.next.next;
			nowNextNode.next = needLinePoint;
		} else {
			// 这里简单的打印一下
			StdOut.print("!------------------删除元素越界！------------------!");
		}
	}

	// 1.3.21——尝试制作：接受一条链表和一个字符串key作为参数
	// 如果链表中的某个节点的item域的值为key，则方法返回true，否则返回false
	// 在这里我们实现的简单一点，就传入this stack
	// 有一个有意思的地方。多调用几次find就会导致多next几次。应该是因为find存进了栈里
	public boolean find(String key) {
		// 其实也可以用foreach
		Node<Item> nowNode = first;
		while (true) {
			if (nowNode.item.equals(key)) {
				StdOut.print("output : true");
				return true;
				// 链表没有下一个了
			} else if (first.next.equals(null)) {
				StdOut.print("output : false");
				return false;
			}
			nowNode = nowNode.next;
			StdOut.println("then next~");
		}

	}

	// 1.3.24 接受一个链表节点作为参数并删除该节点的后续节点
	// ————如果参数节点或参数节点的后续节点为为空则什么都不做
	public void removeAfter(Node<Item> node) {
		if (node == null || node.next == null) {
			// 什么也别做
		} else {
			if (isEmpty())
				throw new NoSuchElementException("Stack underflow");
			Node<Item> tempNode = node.next.next;
			node.next = null;
			node.next = node.next.next;
			n--;
		}
	}

	// 接受一个链表和一个字符串key作为参数，删除链表中所有item域为key的节点
	// 那么为了降低难度，直接写成对this产生作用的方法
	public void remove(String key) {
		// TODO

	}

	/**
	 * Returns an iterator to this stack that iterates through the items in LIFO
	 * order.
	 *
	 * @return an iterator to this stack that iterates through the items in LIFO
	 *         order
	 */
	public Iterator<Item> iterator() {
		return new ListIterator<Item>(first);
	}

	// an iterator, doesn't implement remove() since it's optional
	private class ListIterator<Item> implements Iterator<Item> {
		private Node<Item> current;

		public ListIterator(Node<Item> first) {
			current = first;
		}

		public boolean hasNext() {
			return current != null;
		}

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
