//Exercise 2 
//Write a function that takes an int n as parameter, and creates n threads, running at the same time. Use a for loop to create the threads.
//Each thread should print the numbers from 1 to 100.
//Have the threads print an identifier with each number, so you can see which thread prints what (use the iteration variable from the outer loop where the thread is created).
//a) describe the output. Is it what you expected?
//  The output shows how the threads are created and ther run method is executed accordingly to the schedulers random system.

//b) If the threads do not interleave, can you make them, by making the threads sleep for a short period of time? (think milliseconds).
//They interleave.

package Day1;

/**
 *
 * @author adamlass
 */
public class Exercise2 {
    public static void main(String[] args) {
        new Exercise2().threadmaker(600);
    }
    
    public void threadmaker(int numThreads){
        for (int i = 0; i < numThreads; i++) {
            new Thread(() -> {
                for (int j = 1; j <= 100; j++) {
                    System.out.println(Thread.currentThread().getName() + " - Number: " + j);
                }
            }).start();
        }
    }
}
