#	学习笔记

##	五毒神掌

1. 第一遍
   1. 5-10分钟：读题 有思路就写代码
   2. 直接看优秀的题解
   3. 背诵 闭卷考
2. 第二遍
   1. 第一遍结束后马上自己写
   2. 如果不ac的话，就需要自己在继续debug，直到ac的时候
3. 第三遍
   1. 一天后在进行练习
4. 第四遍
   1. 一周后在进行联系
5. 第五遍
   1. 面试前一到二周进行恢复性联系

## 源码学习

### Queue

特点：先进先出，如果是`窗口`之类的算法题，可以考虑使用队列来实现

#### 主要方法

| 方法               | 作用                                       |
| ------------------ | ------------------------------------------ |
| boolean add(E e)   | 添加一个元素，失败抛出异常                 |
| boolean offer(E e) | 添加一个元素，失败返回false                |
| E remove()         | 移除队列头部的元素并且返回值，失败抛出异常 |
| E poll()           | 移除队列头部的元素并且返回值，失败返回null |
| E element()        | 返回队列头部的元素，没有抛出异常           |
| E peek()           | 返回队列头部的元素，没有返回null           |

### PriorityQueue

优先队列保证每次取出来的元素都有一定的规律，要么最大要么最小，在java中默认权重是最小的。

#### 主要方法

`add`函数直接调用offer

```java
 public boolean add(E e) {
       return offer(e);
  }
```

```java
 public boolean offer(E e) {
           if (e == null)
               throw new NullPointerException();
           modCount++;
           int i = size;
           if (i >= queue.length)
               grow(i + 1); //增大数组的长度
           size = i + 1;
          if (i == 0)
               queue[0] = e;
          else
             siftUp(i, e);   //调整队列里元素的顺序，保证优先队列
             return true;
         }
```

`peek`函数，直接判断size，如果size为0则返回null，否则返回队列头部的元素

```java
 public E peek() {
           if (size == 0)
               return null;
            return (E) queue[0];
}
```

`remove`函数先找到元素的位置，然后移除

```java
public boolean remove(Object o) {
           int i = indexOf(o);
           if (i == -1)
               return false;
           else {
               removeAt(i);
               return true;
            }
       }
```

`poll`函数，先把头部的元素取出，然后把尾部的元素放到头部，在把队列进行调整

```java
public E poll() {
             if (size == 0)
                 return null;
           int s = --size;
           modCount++;
           E result = (E) queue[0];
           E x = (E) queue[s];
           queue[s] = null;
           if (s != 0)
               siftDown(0, x);
           return result;
      }
```

