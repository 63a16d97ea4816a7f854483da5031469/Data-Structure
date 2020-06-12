
/*
 * 
https://leetcode.com/problems/exchange-seats/

1114. Print in Order
Easy

440

63

Add to List

Share
Suppose we have a class:

public class Foo {
  public void first() { print("first"); }
  public void second() { print("second"); }
  public void third() { print("third"); }
}
The same instance of Foo will be passed to three different threads. Thread A will call first(), thread B will call second(), and thread C will call third(). Design a mechanism and modify the program to ensure that second() is executed after first(), and third() is executed after second().

 

Example 1:

Input: [1,2,3]
Output: "firstsecondthird"
Explanation: There are three threads being fired asynchronously. The input [1,2,3] means thread A calls first(), thread B calls second(), and thread C calls third(). "firstsecondthird" is the correct output.
Example 2:

Input: [1,3,2]
Output: "firstsecondthird"
Explanation: The input [1,3,2] means thread A calls first(), thread B calls third(), and thread C calls second(). "firstsecondthird" is the correct output.
 

Note:

We do not know how the threads will be scheduled in the operating system, even though the numbers in the input seems to imply the ordering. The input format you see is mainly to ensure our tests' comprehensiveness.

2 May 2020 at 5.44 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */

//  使用volatile

class Foo {
    private volatile int flag;

    public Foo() {
        flag = 1;
    }

    public void first(Runnable printFirst) throws InterruptedException {
        for(;;) {
        	if (flag==1) {
        		printFirst.run();
                flag = 2;
                break;
        	}
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
    	for(;;) {
    		if (flag==2) {
    			printSecond.run();
                flag=3;
                break;
    		}
    	}
    }

    public void third(Runnable printThird) throws InterruptedException {
    	for(;;) {
    		if (flag==3) {
    			printThird.run();
                flag = 1;
                break;
    		}
    	}
    }
}



// 使用信号量：


class Foo {
    private final AtomicInteger i = new AtomicInteger();
    private final Object lock = new Object();

    public Foo() {
        i.set(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (lock) {
            while (i.get() != 0) {
                lock.wait();
            }
            printFirst.run();
            i.set(1);
            lock.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (lock) {
            while (i.get() != 1) {
                lock.wait();
            }
            printSecond.run();
            i.set(2);
            lock.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (lock) {
            while (i.get() != 2) {
                lock.wait();
            }
            printThird.run();
            i.set(3);
        }
    }
}

————————————————
版权声明：本文为CSDN博主「zhang0peter」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/zhangpeterx/article/details/100569152









