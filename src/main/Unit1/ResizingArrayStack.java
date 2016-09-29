package Unit1;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Camile 下压栈，能够动态调整数组大小的实现
 * @param <Item>
 */
public class ResizingArrayStack<Item> implements Iterable<Item> {
	private Item[] a; // array of items
	private int n; // number of elements on stack

	/**
	 * Initializes an empty stack.
	 */
	public ResizingArrayStack() {
		a = (Item[]) new Object[2];
		n = 0;
	}

	/**
	 * Is this stack empty?
	 * 
	 * @return true if this stack is empty; false otherwise
	 */
	public boolean isEmpty() {
		return n == 0;
	}

	/**
	 * Returns the number of items in the stack.
	 * 
	 * @return the number of items in the stack
	 */
	public int size() {
		return n;
	}

	// resize the underlying array holding the elements
	private void resize(int capacity) {
		// 将栈移动到一个大小为max的新数组
		assert capacity >= n;
		Item[] temp = (Item[]) new Object[capacity];
		for (int i = 0; i < n; i++) {
			temp[i] = a[i];
		}
		a = temp;
	}

	/**
	 * Adds the item to this stack.
	 * 
	 * @param item
	 *            the item to add
	 */
	public void push(Item item) {
		// 将元素添加到栈顶
		if (n == a.length)
			resize(2 * a.length); // double size of array if necessary
		a[n++] = item; // add item
	}

	/**
	 * Removes and returns the item most recently added to this stack.
	 * 
	 * @return the item most recently added
	 * @throws java.util.NoSuchElementException
	 *             if this stack is empty
	 */
	public Item pop() {
		// 从栈顶删除元素
		if (isEmpty())
			throw new NoSuchElementException("Stack underflow");
		Item item = a[n - 1];
		a[n - 1] = null; // to avoid loitering
		n--;
		// shrink size of array if necessary
		if (n > 0 && n == a.length / 4)
			resize(a.length / 2);
		return item;
	}

	/**
	 * Returns (but does not remove) the item most recently added to this stack.
	 * 
	 * @return the item most recently added to this stack
	 * @throws java.util.NoSuchElementException
	 *             if this stack is empty
	 */
	public Item peek() {
		if (isEmpty())
			throw new NoSuchElementException("Stack underflow");
		return a[n - 1];
	}

	/**
	 * Returns an iterator to this stack that iterates through the items in LIFO
	 * order.
	 * 
	 * @return an iterator to this stack that iterates through the items in LIFO
	 *         order.
	 */
	public Iterator<Item> iterator() {
		return new ReverseArrayIterator();
	}

	// an iterator, doesn't implement remove() since it's optional
	private class ReverseArrayIterator implements Iterator<Item> {
		private int i;

		public ReverseArrayIterator() {
			i = n - 1;
		}

		public boolean hasNext() {
			return i >= 0;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

		public Item next() {
			if (!hasNext())
				throw new NoSuchElementException();
			return a[i--];
		}
	}

	/**
	 * Unit tests the <tt>Stack</tt> data type.
	 */
	public static void main(String[] args) {

	}
}
