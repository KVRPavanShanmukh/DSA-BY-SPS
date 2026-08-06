What is Synchronization?

**Synchronization** is the mechanism that ensures **multiple threads access shared resources in a controlled and coordinated way**, preventing incorrect results caused by concurrent execution.

Without synchronization, threads may execute in any order, leading to:

* Race conditions
* Data inconsistency
* Unexpected output

For example:

```java
System.out.println("first");
System.out.println("second");
System.out.println("third");
```

If three different threads execute these statements, the output could be:

```
second
first
third
```

Synchronization ensures the required order:

```
first
second
third
```

---

## Why do we need Synchronization?

Suppose two threads increment the same variable.

```java
count++;
```

This operation is actually:

1. Read `count`
2. Increment
3. Write back

If both threads execute simultaneously:

```
Thread A reads 5
Thread B reads 5
Thread A writes 6
Thread B writes 6
```

Expected value: **7**

Actual value: **6**

This is called a **race condition**.

Synchronization prevents this.

---

# How can Synchronization be achieved in Java?

Java provides several mechanisms.

## 1. synchronized keyword

The simplest and most common approach.

### Synchronized Method

```java
class Counter {
    int count = 0;

    public synchronized void increment() {
        count++;
    }
}
```

Only one thread can execute `increment()` at a time.

---

### Synchronized Block

```java
class Counter {
    int count = 0;

    public void increment() {
        synchronized(this) {
            count++;
        }
    }
}
```

Locks only the critical section.

---

## 2. Lock Interface (ReentrantLock)

Provides more control than `synchronized`.

```java
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Counter {
    Lock lock = new ReentrantLock();
    int count = 0;

    void increment() {
        lock.lock();

        try {
            count++;
        } finally {
            lock.unlock();
        }
    }
}
```

Advantages:

* Try locking
* Timed locking
* Fair locking
* Interruptible locking

---

## 3. volatile Keyword

Used when multiple threads share a variable.

```java
volatile boolean running = true;
```

It guarantees:

* Visibility
* Latest value is read from main memory

It **does not** provide atomicity.

---

## 4. Atomic Classes

Package:

```java
java.util.concurrent.atomic
```

Example:

```java
AtomicInteger count = new AtomicInteger();

count.incrementAndGet();
```

No explicit synchronization required.

---

## 5. wait(), notify(), notifyAll()

Used for communication between threads.

Example:

```java
synchronized(obj) {

    while(!condition)
        obj.wait();

    // do work

    obj.notify();
}
```

Useful for producer-consumer problems.

---

## 6. Semaphores

Control access to a limited number of resources.

```java
Semaphore semaphore = new Semaphore(1);

semaphore.acquire();

// critical section

semaphore.release();
```

A semaphore with one permit behaves similarly to a mutex.

---

## 7. CountDownLatch

Allows one or more threads to wait until a set of operations finishes.

```java
CountDownLatch latch = new CountDownLatch(2);

latch.countDown();
latch.countDown();

latch.await();
```

Often used to coordinate thread startup or completion.

---

## 8. CyclicBarrier

Makes multiple threads wait until all reach the same point.

```java
CyclicBarrier barrier = new CyclicBarrier(3);

barrier.await();
```

Useful in parallel algorithms.

---

## Applying this to the LeetCode "Print in Order" problem

The problem provides three methods:

```java
first()
second()
third()
```

Three threads may call them in **any order**, but the output must always be:

```
first
second
third
```

### One solution using `CountDownLatch`

```java
class Foo {

    CountDownLatch firstDone = new CountDownLatch(1);
    CountDownLatch secondDone = new CountDownLatch(1);

    public Foo() {}

    public void first(Runnable printFirst) {

        printFirst.run();
        firstDone.countDown();
    }

    public void second(Runnable printSecond)
            throws InterruptedException {

        firstDone.await();

        printSecond.run();
        secondDone.countDown();
    }

    public void third(Runnable printThird)
            throws InterruptedException {

        secondDone.await();

        printThird.run();
    }
}
```

Execution flow:

```
Thread 2 --------await()-------------------> second()

Thread 3 ----------------------await()-----> third()

Thread 1 -> first()
             |
             countDown()

Thread 2 resumes
      second()
           |
           countDown()

Thread 3 resumes
      third()
```

Even if `second()` or `third()` are invoked before `first()`, they block until the required predecessor completes.

---

## Summary

| Mechanism                                | Best Use                                     |
| ---------------------------------------- | -------------------------------------------- |
| `synchronized`                           | Mutual exclusion for critical sections       |
| `ReentrantLock`                          | Advanced locking features                    |
| `volatile`                               | Visibility of shared variables               |
| `AtomicInteger` and other atomic classes | Lock-free atomic operations                  |
| `wait()` / `notify()`                    | Thread coordination using object monitors    |
| `Semaphore`                              | Limit concurrent access to resources         |
| `CountDownLatch`                         | Wait for one-time events or task completion  |
| `CyclicBarrier`                          | Synchronize groups of threads at checkpoints |

For the **"Print in Order"** problem, `CountDownLatch` is one of the cleanest solutions because each later method simply waits until the required earlier method has signaled completion.
