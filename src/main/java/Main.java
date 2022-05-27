public class Main {
    public static void main(String[] args) throws InterruptedException {
        // examples of us methods 'notify' and 'wait' for threads

        WaitAndNotify wn = new WaitAndNotify(); // create object of class 'WaitAndNotify'

        // create thread1
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    wn.produce(); // execute method 'produce()' of class 'WaitAndNotify'
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // create thread2
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    wn.consume(); // execute method 'consume()' of class 'WaitAndNotify'
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start(); // the 'wait()' gives away the monitor and wait, when somewhere was called method 'notify'
        thread2.start(); // the 'notify()' wake up thread, where wac used method 'wait()', i.e thread1

        thread1.join(); // join thread1 to main thread
        thread2.join(); // join thread2 to main thread
    }
}
