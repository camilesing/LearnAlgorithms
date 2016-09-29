package Unit1;

public class QuickUnionUF {
	private int[] parent; // parent[i] = parent of i
	private int count; // number of components

	public QuickUnionUF(int n) {
		parent = new int[n];
		count = n;
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
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
	 *            the integer representing one object
	 * @return the component identifier for the component containing site
	 *         {@code p}
	 * @throws IndexOutOfBoundsException
	 *             unless {@code 0 <= p < n}
	 */
	public int find(int p) {
		// 找出分量名称
		validate(p);
		while (p != parent[p])
			p = parent[p];
		return p;
	}

	// validate that p is a valid index
	private void validate(int p) {
		int n = parent.length;
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
		return find(p) == find(q);
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
		// 将p和q的根节点统一
		int rootP = find(p);
		int rootQ = find(q);
		if (rootP == rootQ)
			return;
		parent[rootP] = rootQ;
		count--;
	}

}
