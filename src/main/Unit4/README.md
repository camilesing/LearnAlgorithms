#图
##无向图
>定义：无向图是由一组顶点和一组能够将两个顶点（vertex）相连的边（edge）组成的。

特殊的图：
- 自环：即一条连接一个顶点的其自身的边
- 连接同一对顶点的两条边称为**平行边**

数学级常常将含有平行边的图称为**多重图**，而将没有平行边或自环的图称为**简单图**。
### 术语表
当两个顶点通过一条边相连时，我们称这两个顶点是**相邻的**，并称这条边**依附于**这两个顶点。某个顶点的**度数**即为依附于它的边的总数。子图是由一幅图的所有边的一个子集（以及它们所依附的所有顶点）组成的图。许多计算问题都需要识别各种类型的子图，特别是由能够**顺序**连接这一系列的顶点的边所组成的子图。

>定义：在图中，**路径** 是由边顺序连接的一系列顶点。**简单路径** 是一条没有重复顶点的路径。**环** 是一条至少含有一条边且起点和终点相同的路径。**简单环** 是一条（除了起点和终点必须相同之外）不含有重复顶点和边的环。路径或者环的 **长度** 为其中所包含的边数。

>定义：如果从任意一个顶点都存在一条路径到达另一个任意顶点，我们称这幅图是**连通图**。一副非连通的图是由若干连通的部分组成，它们都是其极大连通子图。

>定义：树是一副无环连通图。互不相连的树组成的集合称为**森林**。连通图的**生成树**是它的一副子图，它含有图中的所有顶点且是一棵树。图的**生成树森林**是它所有连通子图的生成树的集合。

###图的表示方法
####邻接矩阵
我们可以使用一个V乘V的布尔矩阵。当顶点v和顶点w之间有相连接的边时，定义v行w列的元素至为true，否则为false。这种表示方法不符合第一个条件——含有上百个个顶点的图是很常见的，V^2个布尔值锁需要的空间是不能被满足的。

####边的数组
我们可以使用一个Edge类，它含有两个int实例标量。这种表示方法很简洁但不满足第二个条件——要实现adj()需要检查图中的所有边。
####邻接表数组
我们可以使用一个顶点为索引的列表数组，其中的每个元素都是和该顶点相邻的顶点列表。这是一个不错的实现。

**典型Graph实现的性能复杂度**
|数据结构|所需空间|添加一条边v-w|检查w和v是否相邻|遍历v的所有相邻顶点|
|:--|:--|:--|:--|:--|
|边的列表|E|1|E|E|
|邻接矩阵|V^2|1|1|V|
|邻接表|E+V|1|degree(v)|degree(v)|
|邻接表|E+V|logV|logV|logV+degree(v)|

##图处理算法的API
**public class Search**
|返回类型|方法名|简介|
|:--|:--|:--|
||Search(Graph g,int s)|找到和起点s连通的所有点|
|boolean|marked(int v)|v和s是连通的吗|
|int |count()|与s连通的顶点总数|

###深度优先算法
主要思想：
- 用一个递归的方法来遍历所有顶点
- 将它标记为已访问
- 递归地访问它的所有没有被标记的邻居顶点


>深度优先搜索标记与起点连通的所欲哦顶点所需的时间和顶点的读书之和成正比。

## 寻找路径
**public class Search**
|返回类型|方法名|简介|
|:--|:--|:--|
||Paths(Graph g,int s)|从G中找出所有起点为s的路径|
|boolean|hasPathTo(int v)|是否存在从s到v的路径|
|Iterable<Integer>|pathTo()|s到v的路径，如果不存在则返回null|

### 广度优先搜索
深度优先搜索得到的路径不仅是取决于图的结构，还取决于图的表示和递归调用的兴致。我们很自然地还经常对下面这些问题感兴趣。

>单点最短路径。给定一幅图和一个起点s，回答“从s到给定目的顶点v是否存在一条路径？如果有，找出其中最短的那条（所含边数最少）。等类似问题”

解决这个问题的经典方法叫做**广度优先搜索（BFS）** 。因为深度优先搜索在这个问题上没有什么作为，因为它遍历整个图的顺序和找出最短路径的目标没有任何关系。

在深度优先搜索中，我们用了一个可以下压的栈（由系统管理，以支持递归搜索方法）。使用LIFO（后进先出）的规则来描述压栈和走迷宫时先探索相邻的通道类似。从有待搜索的通道中选择最晚遇到过的那条。在广度优先搜索中，我们希望按照起点的举例的顺序来遍历所有顶点，看起来这种顺序很容易实现：使用（FIFO，先进先出）队列来替代栈（LIFO，先进后出）即可。我们将从有待搜索的通道中选择最早遇到的那条。

####实现
`BreadthFirstPaths`实现了广度优先搜索算法。它使用了一个队列来保存所有已经被标记但其领表还未被检查过的顶点。先将起点加入队列，然后重复以下步骤知道队列为空：
1. 取队列中的下一个顶点v并标记它
2. 将与v相邻的所有未被标记过的顶点加入队列

在这里，bfs()方法不是递归的。不像递归中隐式使用的栈，它显示地使用了一个队列。

对于从s可大的任意顶点v，广度优先搜索都能找到一条从s到v的最短路径（没有其他从s到v的路径所含的边比这条路径更少）。另外，广度优先搜索所需的时间在最坏情况下和V+E成正比。

###小结
深度优先搜索和广度优先搜索是几种常用并且通用的图搜索的算法。在搜索中我们都会将起点存入数据结构中，然后重复以下步骤直到数据结构被清空：
1. 取其中的下一个顶点并标记它
2. 将v的所有相邻而又未被标记的顶点加入数据结构

###连通分量
深度优先搜索的下一个直接应用就是找出一幅图的所有连通分量。

**CC类的API**
|返回类型|方法名|简介|
|:--|:--|:--|
||CC(Graph G)|预处理构造函数|
|boolean|connected(int v, int w)|v和w连通吗|
|int|count()|连通分量数|
|int|id(int v)|v所在的连通分量的标识符(0~count()-1)|

###符号图
在典型应用中，图都是通过文件或者网页定义的，使用的是字符串而非整数来表示和指代顶点。为了适应这样的应用，我们定义了拥有以下性质的输入格式：
- 顶点名为字符串
- 用指定的分隔符来隔开顶点名（允许顶点名中含有空格）
- 每一行都表示一组边的集合，每一条边都连接着这一行的第一个名称表示的顶点和其他名称所表示的顶点
- 顶点总数V和边的总数E都是隐式定义的

**SymbolGraph类的API**
|返回类型|方法名|简介|
|:--|:--|:--|
||SymbolGraph(String filename,String delim)|根据filename指定的文件构造图，使用delim来分隔顶点名|
|boolean|contains(String key)|key是一个顶点吗|
|int|index(String key)|Key的索引|
|String|name(int v)|索引v的顶点名|
|Graph|G()|隐藏的Graph对象|

####实现
SymbolGraph的用到了下面3种数据结构：
- 一个符号表st，键的类型为String(顶点名)，值的类型为int（索引）
- 一个数组Keys[]，用作反向索引，保存每个顶点索引所对应的顶点名
- 一个Graph对象G，它使用索引来引用图中顶点

## 有向图
>定义：一副有方向性的图（或有向图）的由一组顶点和一组有方向的边组成的，每条有方向的边都连接这有序的一对顶点。

我们称一条有向边由第一个顶点指出并指向第二个顶点。在一副有向图中，一个顶点的**出度**为由该顶点指出的边的总数；一个顶点的**入度**为指向该顶点的边的总数。当上下文的意义明确时，我们在提到有向图的边时会省略**有向**二字。一条有向边的第一个顶点称它的**头**，第二个顶点则被称为它的**尾**。将有向图画为由头指向尾的一个箭头。用v->w来表示有向图中一条由v指向w的边。一副有向图中的两个顶点的关系可能有4种：
- 没有边相连
- 存在从v到w的边v->w
- 存在从w到v的边w->v
- 既存在v->w也存在w->v，即双向连接

>定义：在一副有向图中，**有向路径** 由一系列顶点组成，对于其中的每个顶点都存在一条有向边从它指向序列中的下一个顶点。**有向环** 为一条至少含有一条边且切点和终点相同的有向路径。简单有向环是一条（除了起点和终点必须相同之外）不含有重复的顶点和边的环。路径或者环的 **长度** 即为其中所包含的边数。

和无向图一样，我们架设有向路径都是简单的，除非我们明确指出某个重复了的顶点（像有向环的定义那样）或是指明是一般性的有向路径。当存在从v到w的有向路径时，称顶点w能够由顶点v**达到**。我们约定，每个顶点都能够达到它自己。除了这种情况之外，在有向图中由v能够到达w并不意味着w也能到底v。这个不同虽然很明显但非常重要，后面将会看到这一点。

**有向图——Digraph的API**
|返回类型|方法名|简介|
|:--|:--|:--|
||Digraph的API(int V)|创建一副含有V个顶点但是没有边的有向图|
||Digraph的API(In in)|从输入流in中读取一副有向图|
|int|V()|顶点总数|
|int|E()|边的总数|
|Iterable<Integer>|adj(int v)|由v指出的边所连接的所有顶点|
|Digraph|reverse())|该图的反向图|
|String|toString|对象的字符串表示|

###有向图的可达性
**DirectedDFS的API**
|返回类型|方法名|简介|
|:--|:--|:--|
||DirectedDFS(Digraph G,int s)|从G中找到从s可达的所有顶点（单点可达性）|
||DirectedDFS(Digraph G,Interable<Integer>sources|在G中找到从sources中的所有顶点可达的所有顶点（多点可达性）|
|boolean|marked(int v)|v是可达的吗|

### 有向环
在某些场景中判断有向图是否存在环还是挺重要的。

一旦我们找到了一条有向边v->w且w已经存在于栈中，就找到了一个环，因为栈表示的是一条由w到v的有向路径，而v->w正好补全了这个环。同时，如果没有找到这样的边，那就意味着这幅有向图是无环的。

**DirectedCycle的API**
|返回类型|方法名|简介|
|:--|:--|:--|
||DirectedCycle(Digraph G)|寻找有向环的构造函数|
|boolean|hasCycle()|G是否含有有向环|
|Iterable|cycle()|有向环的所有顶点（如果存在的话）|

###拓扑排序
**Topological的API**
|返回类型|方法名|简介|
|:--|:--|:--|
||Topological(Digraph G)|拓扑排序的构造函数|
|boolean|isDAG()|G是有向无环图|
|Iterable<Integer>|order()|拓扑有序的所有顶点|

这个算法很像一种拓扑算法——有向图中基于深度优先搜索的顶点顺序的`DepthFirstOrder`类。它的基本思想是深度优先搜索正好只会访问每个顶点一次。如果将dfs()的参数顶点保存在一个数据结构中，遍历这个数据结构实际上就能够访问图中的所有顶点，遍历的顺序取决于这个数据结构的性质以及是在递归调用之前还是之后进行保存。在典型的应用中，人们感兴趣的是顶点的以下3种排列顺序：
- 前序：在递归调用之前将顶点加入队列。
- 后序：在递归调用之后将顶点加入队列。
- 逆后续：在递归调用之后将顶点压入栈。

###有向图中的强连通性
>定义：如果两个顶点v和w是互相可达的，则称它们为**强连通**的。也就是说，既存在一条从v到w的有向路径，也存在一条从w到v的有向路径。如果一副有向图的任意两个顶点都是强连通的，则称这幅有向图是**强连通**的。

>两个顶点是强连通的当且仅当它们都在一个普通的有向环中。

####强连通分量
和无向图中的连通性一样，有向图中的强连通性也是一种顶点之间等价关系，因为它有着以下性质：
- 自反性：任意顶点v和自己都是强连通的。
- 对称性：如果v和w是强连通的，那么w和v也是强连通的。
- 传递性：如果v和w是强连通的且w和x也是强连通的，那么v和x也是强连通的。

作为一种等价关系，强连通性将所有顶点分为一些等价类，每个等价类都是由相互均为强连通的顶点的最大子集组成的。我们将这些子集称为**强连通分量**。

>一个强连通图只含有一个强连通分量，而一个有向无环图中则含有V个强连通分量。

**强连通分量——SCC的API**
|返回类型|方法名|简介|
|:--|:--|:--|
||SCC(Digraph G)|预处理构造函数|
|boolean|stronglyConnected(int v,int w)|v和w是强连通的吗|
|int|count()|图中的强连通分量的总数|
|int|id(int v)|v所在的强连通分量的标示符（在0至count(0)-1之间）|

- 在给定的一副有向图G中，使用DepthFirstOrder来计算它的反向图G^R的逆后续排列。
- 在G中进行标准的深度优先搜索，但是要按照刚才计算得到的顺序而非标准的顺序来访问所有未被标记的顶点。
- 在构造函数中，所有在同一个递归dfs()调用中被访问到的顶点都在同一个**强连通**分量中，将它们按照和CC相同的方式识别出来。

简单来说就是按照原来方向深度一遍，然后逆方向深度一遍。

##最小生成树
> **加权图** 是一种为每条边关联一个**权值**或是**成本**的图模型。这种图能够自然地表示许多应用。在一副航空图中，边表示航线，权值则可以表示距离或是费用。在这类情景中，最令人感兴趣的自然是将成本最小化。

先回顾一下树的两个最重要性质：
- 用一条边连接树中的任意两个顶点都会产生一个新的环
- 从树中删去一条边将会得到两颗独立的树

这两条性质是证明最小生成树的另一条基本性质的基础，而由这条基本性质就能够获得最小生成树算法。

####切分定理
我们称之为切分定理的这条性质将会把加权图中的所有顶点分为两个集合、检查横跨两个集合的所有边并识别哪条边应属于图的最小生成树。

> 图的一种**切分**是将图的所有顶点分为两个非空且不重叠的两个集合。**横切边** 是一条连接两个属于不同集合的顶点的边。

>**切分定理：** 在一副加权图中，给定任意的切分，它的横切边中的权重最小者必然属于图的最小生成树。

#### 贪心算法
切分定理是解决最小生成树问题的所有算法的基础。更确切的说，这些算法都是一种**贪心算法**的特殊情况：使用切分定理找到最小生成树的一条边，不断重复找到最小生成树的所有边。这些算法互相之间的不同之处还在于保存切分和判定权重最小的横切边的方式，但它们都是以下性质的特殊情况。

###加权无向图的数据类型

**加权边——Edge的API**
|返回类型|方法名|简介|
|:--|:--|:--|
||Edge(int v,int w, double weight)|用于初始化的构造函数|
|double|weight()|边的权重|
|int|either()|边两端的顶点之一|
|int|other(int v)|另一个顶点|
|int|compareTo(Edge that)|将这条边与that比较|
|String|toString()|对象的字符串表示|

**加权无向图——EdgeWeightedGraph的API**
|返回类型|方法名|简介|
|:--|:--|:--|
||EdgeWeightedGraph(int v)|创建一副含有V个顶点的空图|
||EdgeWeightedGraph(In in)|从输入流中读取图|
|int|V()|图的顶点树|
|int|E()|图的边数|
|Iterable<Edge>|adj(int v)|和v相关联的所有边|
|Iterable<Edge>|edges()|返回加权无向图中的所有边|
|String|toString()|对象的字符串表示|

### 最小生成树的API
由于图G的最小生成树是G的一副子图并且同时也是一副树，因此我们有很多选择，最主要的几种表示方法：
- 一组边的列表
- 一副加权无向图
- 一个以顶点为索引且含有父结点链接的数组

**MST**
|返回类型|方法名|简介|
|:--|:--|:--|
||MST(EdgeWeightedGraph G))|构造函数|
|Iterable|edges()|最小生成树的所有边|
|double|weight()|最小生成树的权重|

####延时的Prim算法
它的每一步都会为一棵生长中的树添加一条边。一开始这棵树只有一个顶点，然后会向它添加V-1条边，每次总是将下一条连接树中的顶点与不在树中的顶点且权重最小的边加入树中（即由树中的顶点所定义的切分中的一条横切边）。
#####数据结构
- 顶点：使用一个由顶点索引的布尔数组marked[]，如果顶点V在书中，那么marked[v]值为true。
- 边：选择以下两种数据结构之一：一条队列mst来保存最小生成树中的边，或者一个由顶点索引的Edge对象的数组edgeTo[]，其中edgeTo[v]为将v连接到树中的Edge对象。
- 横切边：使用一条优先队列MinPQ<Edge>来根据权重比较所有边。  

#####维护横切边的集合
每当我们向树中添加了一条边之后，也向树中添加了一个顶点。要维护一个包含所有横切边的集合，就要将连接这个顶点和其他所有不在树中的顶点的边加入优先队列（用marked[]来识别这样的边）。但还有一点：连接新加入树中的顶点与其他已经在树中顶点的所有边都失效了。Prim算法的即时实现可以将这样的边从优先队列中删除，但我们先来学习这个算法的一种延时实现，将这些边先留在优先队列中，等到要删除它们的时候再检查边的有效性。

#####运行时间
Prim算法的延时实现计算一副含有V个顶点和E条边的连通加权无向图的最小生成树所需的空间与E成正比，所需的时间与ElogE成正比（最坏情况）。

####即时的Prim算法
要改进LazyPrimMST，可以尝试从优先队列中删除失效的边，这样优先队列就只含有树顶点和非树顶点之间的横切边，但其实还可以删除更多的边。关键在于，我们感兴趣的只是连接树顶点和非树顶点中权重最小的边。当我们将顶点v添加到树中时，对于每个非树顶点w产生的变化只可能使得w到最小生成树中的距离更近了。简而言之，我们不需要在优先队列中保存所有从w到树顶点的边——而只需要保存其中权值最小的那条，在将v添加到树中后检查是否需要更新这条权重最小的那条，在将v添加到树中后检查是否需要更新这条权重最小的边（因为v-w的权重可能更小）。我们只需遍历v的邻接链表就可以完成这个任务。换句话说，我们只会在优先队列中保存每个非树顶店w的一条边；将它与树中的顶点连接起来的权重最小的那条边。将w和树的顶点连接起来的其他权重较大的边迟早都会失效，所以没必要在优先队列中保存它们。

###Kruskal算法
这个算法的主要思想是按照边的权重顺序（从小到达）处理它们，将边加入最小生成树中（图中的黑色边），加入的边不会与已经加入的边构成环，直到树中含有V-1条边为止。这些黑色的边逐渐由一片森林合并为一棵树，也就是图的最小生成树。

>Kruskal算法能够计算任意加权连通图的最小生成树。

Prim算法是一条边一条边地来构造最小生成树，每一步都为了一棵树添加一条边。Kruskal算法最小生成树的时候也是一条边一条边地构造，但不同的是它寻找的边会连接一片森林中的两棵树。我们从一篇由V棵单顶点的树构成的森林开始并不断将两棵树合并（用可以找到的最短边）直到只剩下一棵树，它就是最小生成树。

>Kruskal算法的计算一副含有V个顶点和E条边的连通加权无向图的最小生成树所需的空间和E成正比，所需的时间和ElogE成正比（最坏情况）。


###小结
各种最小生成树算法的性能特点（V个顶点E条边，最坏情况下的增长数量级）
|算法|空间|时间|
|:--|:--|:--|
|延时的Prim算法|E|ElogE|
|即时的Prim算法|V|ElogE|
|Kruskal|E|ElogE|
|Fredman-Tarjan|V|E+logV|
|Chazelle|V|非常接近但还没有达到E|
|理想情况|V|E?|
