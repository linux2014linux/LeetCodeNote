package Java.Solution.Other.MultiThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程顺序执行
 * 参考: https://www.cnblogs.com/hoonick/p/10794968.html
 */
public class SequenceExecute {

  /**
   * synchronized + wait + notifyAll
   * synchronized 等同于 lock
   */
  public class Way1 {

    private int flag;

    public Way1() {
      this.flag = 1;
    }

    public synchronized void printA() {
      while (flag != 1) {
        try {
          this.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      System.out.println(Thread.currentThread().getName());
      flag = 2;
      this.notifyAll();
    }

    public synchronized void printB() {
      while (flag != 2) {
        try {
          this.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      System.out.println(Thread.currentThread().getName());
      flag = 3;
      this.notifyAll();
    }

    public synchronized void printC() {
      while (flag != 3) {
        try {
          this.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      System.out.println(Thread.currentThread().getName());
      flag = 1;
      this.notifyAll();
    }
  }
  public void print1() {
    final Way1 way1 = new Way1();
    final int times = 100;
    Thread t1 = new Thread(new Runnable() {
      @Override
      public void run() {
        int i = 0;
        while (i < times) {
          way1.printA();
          i++;
        }
      }
    }, "A");
    Thread t2 = new Thread(new Runnable() {
      @Override
      public void run() {
        int i = 0;
        while (i < times) {
          way1.printB();
          i++;
        }
      }
    }, "B");
    Thread t3 = new Thread(new Runnable() {
      @Override
      public void run() {
        int i = 0;
        while (i < times) {
          way1.printC();
          i++;
        }
      }
    }, "C");

    t3.start();
    t1.start();
    t2.start();
    try {
      t1.join();
      t2.join();
      t3.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  /**
   * lock + condition + await + signal
   */
  public class Way2 {

    private int flag;
    private Lock lock;
    private Condition conditionA;
    private Condition conditionB;
    private Condition conditionC;

    public Way2() {
      this.flag = 1;
      this.lock = new ReentrantLock();
      this.conditionA = lock.newCondition();
      this.conditionB = lock.newCondition();
      this.conditionC = lock.newCondition();
    }

    public void printA() {
      lock.lock();
      while (flag != 1) {
        try {
          conditionA.await();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      System.out.println(Thread.currentThread().getName());
      flag = 2;
      conditionB.signal();
      lock.unlock();
    }

    public void printB() {
      lock.lock();
      while (flag != 2) {
        try {
          conditionB.await();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      System.out.println(Thread.currentThread().getName());
      flag = 3;
      conditionC.signal();
      lock.unlock();
    }

    private void printC() {
      lock.lock();
      while (flag != 3) {
        try {
          conditionC.await();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      System.out.println(Thread.currentThread().getName());
      flag = 1;
      conditionA.signal();
      lock.unlock();
    }
  }
  public void print2() {
    final Way2 way2 = new Way2();
    final int times = 100;
    Thread t1 = new Thread(new Runnable() {
      @Override
      public void run() {
        int i = 0;
        while (i < times) {
          way2.printA();
          i++;
        }
      }
    }, "A");
    Thread t2 = new Thread(new Runnable() {
      @Override
      public void run() {
        int i = 0;
        while (i < times) {
          way2.printB();
          i++;
        }
      }
    }, "B");
    Thread t3 = new Thread(new Runnable() {
      @Override
      public void run() {
        int i = 0;
        while (i < times) {
          way2.printC();
          i++;
        }
      }
    }, "C");

    t3.start();
    t1.start();
    t2.start();
    try {
      t1.join();
      t2.join();
      t3.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
