
//Exercise 1 (create, start and end threads)
//Create a program that starts 3 different parallel threads.
//
//thread1: Compute and print the sum of all numbers from 1 to 1 billion
//thread2: Print the numbers from 1 to 5. Pause for 2 seconds between each print.
//thread3: Print all numbers from 10 and up. Pause for 3 seconds between each print.
//
//The program should stop thread3 after 10 seconds.
//
//Hint: 	For the sum in thread1, use the a long data type, the result is about 5e+17
//Hint2: 	Let the main thread sleep for 10 seconds after starting thread3. The Thread class has a    static method “sleep(n)”, which takes an integer n, and makes the calling thread sleep for n milliseconds.
//Hint3: 	Use a Boolean value in the loop in thread3 to terminate task3 (let the main thread 
//change the value of the boolean value).

package Day1;

/**
 *
 * @author adamlass
 */
public class Exercise1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 1000000000; i++) {
                System.out.println("THREAD 1: " + i);
            }
        });

        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 5; i++) {
                    System.out.println("THREAD 2: " + i);
                    try {
                        Thread.sleep(2000);
                    } catch (Exception e) {

                    }
                }
            }
        };

        Thread t2 = new Thread(r);
        
        Thread t3 = new Thread() {
            @Override
            public void run() {
                int i = 10;
                while (!Thread.interrupted()) {
                    System.out.println("THREAD 3: " + i++);
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.out.println("INTERRUPTED");
                    }
                }
            }
        };
        
        t1.start();
        t2.start();
        t3.start();
        
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("10 sec sleep was interupted!");
        }
        
        t3.interrupt();
        System.out.println("DONE!");
        

    }

}
