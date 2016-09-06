package Unit1;

public class QuickFindUF {
	private int[] id; // 分量id，分量是一组元素的集合
	private int count; // 分量数量

	/**
	 * Init
	 * 
	 * @param n
	 */
	public QuickFindUF(int n) {
		count = n;
		id = new int[n];
		for (int i = 0; i < n; i++)
			id[i] = i;
	}

	/**
	 * Returns the number of components.
	 *
	 * @return the number of components (between {@code 1} and {@code n})
	 */
	public int count() {
		return count;
	}

	/**
	 * Returns the component identifier for the component containing site
	 * {@code p}.
	 *
	 * @param p
	 *            the integer representing one site
	 * @return the component identifier for the component containing site
	 *         {@code p}
	 * @throws IndexOutOfBoundsException
	 *             unless {@code 0 <= p < n}
	 */
	public int find(int p) {
		validate(p);
		return id[p];
	}

	// validate that p is a valid index
	private void validate(int p) {
		int n = id.length;
		if (p < 0 || p >= n) {
			throw new IndexOutOfBoundsException("index " + p + " is not between 0 and " + (n - 1));
		}
	}

	/**
	 * Returns true if the the two sites are in the same component.
	 *
	 * @param p
	 *            the integer representing one site
	 * @param q
	 *            the integer representing the other site
	 * @return {@code true} if the two sites {@code p} and {@code q} are in the
	 *         same component; {@code false} otherwise
	 * @throws IndexOutOfBoundsException
	 *             unless both {@code 0 <= p < n} and {@code 0 <= q < n}
	 */
	public boolean connected(int p, int q) {
		validate(p);
		validate(q);
		return id[p] == id[q];
	}

	/**
	 * Merges the component containing site {@code p} with the the component
	 * containing site {@code q}.
	 *
	 * @param p
	 *            the integer representing one site
	 * @param q
	 *            the integer representing the other site
	 * @throws IndexOutOfBoundsException
	 *             unless both {@code 0 <= p < n} and {@code 0 <= q < n}
	 */
	public void union(int p, int q) {
		// 将p和q归并到相同的分量
		find(p);
		find(q);
		int pID = id[p]; // needed for correctness
		int qID = id[q]; // to reduce the number of array accesses

		// p and q are already in the same component
		if (pID == qID)
			return;

		// 将p的分量重命名为q的名称
		for (int i = 0; i < id.length; i++)
			if (id[i] == pID)
				id[i] = qID;
		count--;
	}

}
