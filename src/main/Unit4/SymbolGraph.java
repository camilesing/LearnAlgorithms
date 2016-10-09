package Unit4;

import Tools.*;

/**
 * 符号图
 *
 */
public class SymbolGraph {
    private ST<String, Integer> st;  // 符号名 -> 索引
    private String[] keys;           // 索引  -> 符号名
    private Graph graph;             // 图

    /**  
     * Initializes a graph from a file using the specified delimiter.
     * Each line in the file contains
     * the name of a vertex, followed by a list of the names
     * of the vertices adjacent to that vertex, separated by the delimiter.
     * @param filename the name of the file
     * @param delimiter the delimiter between fields
     */
    public SymbolGraph(String filename, String delimiter) {
        st = new ST<String, Integer>();

        // First pass builds the index by reading strings to associate 第一遍
        // distinct strings with an index
        In in = new In(filename);
        //构造索引
        while (!in.isEmpty()) { 
        	//读取字符串
            String[] a = in.readLine().split(delimiter); 
          //为每个不同的字符串关联一个索引
            for (int i = 0; i < a.length; i++) { 
                if (!st.contains(a[i]))
                    st.put(a[i], st.size());
            }
        }
        StdOut.println("Done reading " + filename);

        // 用来获得顶点名的反向索引是一个数组
        keys = new String[st.size()];
        for (String name : st.keys()) {
            keys[st.get(name)] = name;
        }

        // second pass builds the graph by connecting first vertex on each
        // line to all others
        graph = new Graph(st.size());
        //第二遍
        in = new In(filename);
        //构造图
        while (in.hasNextLine()) {
            //将每一行的第一个顶点和该行的其他顶点相连
        	String[] a = in.readLine().split(delimiter);
            int v = st.get(a[0]);
            for (int i = 1; i < a.length; i++) {
                int w = st.get(a[i]);
                graph.addEdge(v, w);
            }
        }
    }

    /**
     * Does the graph contain the vertex named {@code s}?
     * @param s the name of a vertex
     * @return {@code true} if {@code s} is the name of a vertex, and {@code false} otherwise
     */
    public boolean contains(String s) {
        return st.contains(s);
    }

    /**
     * Returns the integer associated with the vertex named {@code s}.
     * @param s the name of a vertex
     * @return the integer (between 0 and <em>V</em> - 1) associated with the vertex named {@code s}
     * @deprecated Replaced by {@link #indexOf(String)}.
     */
    @Deprecated
    public int index(String s) {
        return st.get(s);
    }


    /**
     * Returns the integer associated with the vertex named {@code s}.
     * @param s the name of a vertex
     * @return the integer (between 0 and <em>V</em> - 1) associated with the vertex named {@code s}
     */
    public int indexOf(String s) {
        return st.get(s);
    }

    /**
     * Returns the name of the vertex associated with the integer {@code v}.
     * @param v the integer corresponding to a vertex (between 0 and <em>V</em> - 1) 
     * @return the name of the vertex associated with the integer {@code v}
     * @deprecated Replaced by {@link #nameOf(int)}.
     */
    @Deprecated
    public String name(int v) {
        return keys[v];
    }

    /**
     * Returns the name of the vertex associated with the integer {@code v}.
     * @param v the integer corresponding to a vertex (between 0 and <em>V</em> - 1) 
     * @return the name of the vertex associated with the integer {@code v}
     */
    public String nameOf(int v) {
        return keys[v];
    }

    /**
     * Returns the graph assoicated with the symbol graph. It is the client's responsibility
     * not to mutate the graph.
     * @return the graph associated with the symbol graph
     * @deprecated Replaced by {@link #graph()}.
     */
    @Deprecated
    public Graph G() {
        return graph;
    }

    /**
     * Returns the graph assoicated with the symbol graph. It is the client's responsibility
     * not to mutate the graph.
     * @return the graph associated with the symbol graph
     */
    public Graph graph() {
        return graph;
    }


}
