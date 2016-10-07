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