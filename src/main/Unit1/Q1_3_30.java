package Unit1;


/**
 * @author Camile
 */
public class Q1_3_30 {
	private static class Node<Item> {
		private Item item;
		private Node<Item> next;
	}

	/**
	 * @param x
	 * 我们需要记录链表中三个连续的结点：reverse、first和second。在每轮迭代中，我们从原链表中提取结点first并将它插入到逆链表的开头
	 * 我们需要一直保持first指向原链表中所有剩余的结点的首结点，
	 * second指向原链表中所有剩余结点的第二个结点，reverse指向结果链表中的首节点
	 * @return
	 * 最后要补充的是：请小心处理异常情况——链表为空或是只有1、2个结点和边界的情况（处理首尾节点）。
	 */
	public Node reverse_1(Node x) {
		Node first = x;
		Node reverse = null;
		while (first != null) {
			Node second = first.next;
			first.next = reverse;
			reverse = first;
			first = second;
		}
		return reverse;
	}

	/**
	 * @param first
	 * 假设链表有N个结点，我们先递归颠倒最后N-1个结点，然后小心地将原链表中的首结点插入到结果链表的末端。
	 * @return
	 */
	public Node reverse_2(Node first) {
		if (first == null)
			return null;
		if (first.next == null)
			return first;
		Node second = first.next;
		Node rest = reverse_2(second);
		second.next = first;
		first.next = null;
		return rest;
	}
}
