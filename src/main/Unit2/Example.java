package Unit2;

import Tools.StdOut;
import edu.princeton.cs.algs4.In;

/**
 * 排序算法类的模板
 * 
 * @author Camile
 *
 */
public class Example {

	/**
	 * 排序主体
	 * @param a
	 */
	public static void sort(Comparable[] a) {
	}

	
	/**
	 * 对元素进行比较
	 * @param v
	 * @param w
	 * @return
	 */
	public static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	/**
	 * 将元素交换位置
	 * @param a
	 * @param i
	 * @param j
	 */
	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	/**
	 *  在单行中打印数组
	 * @param a
	 */
	private static void show(Comparable[] a) {
		
		for (int i = 0; i < a.length; i++) {
			StdOut.print(a[i] + "");
		}
		StdOut.println();
	}

	public static boolean isSorted(Comparable[] a) {
		// 测试数组元素是否有序
		for (int i = 1; i < a.length; i++) {
			if (less(a[i], a[i - 1]))
				return false;
		}
		return false;
	}
	public static void main(String[]args){
		//从标准输入读取字符串，将它们排序并输出
		String[]a=In.readStrings();
		sort(a);
		//判断数组是否有序
		assert isSorted(a);
		show(a);
	}
}
