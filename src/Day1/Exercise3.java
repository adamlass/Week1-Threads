/*
 * Exercise 3 (race condition)

The method next() in the class Even should always return an even number (see code snippet below). You will implement a program that demonstrates that this is not always true in a multithreaded program.

Create at least two threads, which both should call the next() method on the same Even object and test if the return value is even. Experiment with the number of calls each thread makes to next().


public class Even
{
  private int n = 0;
  public int next()
  {
    n++;
    n++;
    return n;
  }
}

a) Are you able to provoke the expected error on your machine?
yes

b) How often does the problem occur?
1/20 times

c) Use the synchronization techniques you’ve learned today, to make next() method atomic with respect to itself.
d) Argue that your solution is correct (argue, don’t prove)
Since the program is locking the incrementing and returning part of the function, 2 calls will never interfear and cause an odd number
 */
package Day1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adamlass
 */
public class Exercise3 {

    public static void main(String[] args) {

        class Even {
            
            
            private int n = 0;

            public synchronized int next() {
                    n++;
                    n++;
                    return n;
            }
        }

        Even even = new Even();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            threads.add(new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " - Next: " + even.next());
            }));

        }
        for (Thread thread : threads) {
            thread.start();
        }
    }

}
