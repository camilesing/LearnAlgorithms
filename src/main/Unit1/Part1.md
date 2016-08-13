#基本数据类型
**泛型可迭代的基础集合数据类型的API**
## Bag-背包
```java
public class Bag<Item> implements Iterable<Item>
```
###API
|返回类型|方法名|描述|
|:--|:--|:--|
||Bag()|创建一个空背包|
|void|add(Item item)|添加一个元素|
|boolean|isEmpty()|背包是否为空|
|int|size()|背包中的元素数量|

## FIFO-（先进先出）队列

```java
public class Queue<Item>implements Iterable<Item>
```
###API
|返回类型|方法名|描述|
|:--|:--|:--|
||Queue()|创建空队列|
|void|enqueue()|添加一个元素|
|Item|dequeue()|删除最早添加的元素|
|boolean|isEmpty()|队列是否为空|
|int|size()|队列中的元素数量|

## LIFO-（后进先出）栈
```java
public class Stack<Item>implements Iterable<Item>
```
###API
|返回类型|方法名|描述|
|:--|:--|:--|
||Stack()|创建一个空栈|
|void|push(Item item)|添加一个元素|
|Item|pop()|删除最近添加的元素|
|boolean|isEmpty()|栈是否为空|
|int|size()|栈中的元素数量|

## 链表
优点：
- 它可以处理任意类型的数据；
- 所需的空间总是和集合的大小成正比；
- 操作所需的时间总是和集合的大小无关；

缺点：需要通过引用访问任意元素
