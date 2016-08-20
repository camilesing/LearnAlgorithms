package Unit1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import Unit1.Queue.Node;

public class DoubleLinkedList<Item> implements Iterable<Item> {
	private Node<Item> first;
	private Node<Item> last;
	private int n;

	private static class Node<Item> {
		private Node<Item> previous;
		private Item item;
		private Node<Item> next;
	}

	// 如果链表为空去添加 函数
	// private void ifIsEmptyToIncrease(Item item){
	// if(isEmpty()){
	// // 如果链表为空。那么它就是唯一的结点——首结点是它，尾结点也是它。
	// first.previous = null;
	// first.item = item;
	// first.next = null;
	// last.previous = null;
	// last.item = item;
	// last.next = null;
	// n++;
	// }
	// }

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
			throw new NoSuchElementException("DoubleLinkedList underflow");
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
			throw new NoSuchElementException("DoubleLinkedList underflow");
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
//以下方法都没有对特殊情况进行判断，比如数量为0、1等...
	// 在指定结点前插入
	public void insertBefore(Node<Item> node,Node<Item> newNode){
		//处理前面的指向
		newNode.previous = node.previous;
		node.previous.next = newNode;
		//处理后面的指向
		newNode.next = node;
		node.previous = newNode;	
		n++;
	}
	// 在指定结点后插入
	public void insertAfter(Node<Item>node,Node<Item>newNode){
		//处理后面的指向
		newNode.next = node.next;
		node.next.previous =newNode;
		//处理前面的指向
		newNode.previous = node;
		node.next = newNode;
		n++;
	}
	// 从指定结点前删除
	public void deleteBefore(Node<Item>node){
		//前一个节点指向前前一个
		node.previous = node.previous.previous;
		node.previous.next = node;	
		n--;
	}
	// 从指定结点后删除
	public void deleteAfter(Node<Item>node){
		node.next = node.next.next;
		node.next.previous = node;
		n --;
		List <Item>list = new ArrayList();
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

		//必须被实现的方法1
		public boolean hasNext() {
			return current != null;
		}

		//必须被实现的方法2
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
