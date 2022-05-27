import java.util.Scanner;

public class WaitAndNotify {

    public void produce() throws InterruptedException {

        synchronized (this) { // we synchronized on the object 'wn' of class 'WaitAndNotify'
            System.out.println("Producer threat started...");
            this.wait(); // you may use wait() only inside synchronized block and on object, where go synchronization, (this)
            // 1 - we return intrinsic lock, 2 - we wait when called 'notify' on this object, 3 - continue work
            System.out.println("Producer thread resume...");
        }
    }

    public void consume() throws InterruptedException {
        Thread.sleep(2000); // sleep
        Scanner scanner = new Scanner(System.in);

        synchronized (this) { // we synchronized on the object 'wn' of class 'WaitAndNotify'
            System.out.println("Waiting for return key pressed");
            scanner.nextLine(); // wait for 'Enter' key pressed
            this.notify(); // wake up thread, only one thread of all threads
        }
    }

}
