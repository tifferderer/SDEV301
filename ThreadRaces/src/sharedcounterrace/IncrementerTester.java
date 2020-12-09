package sharedcounterrace;

public class IncrementerTester {

    public static void main(String[] args) throws InterruptedException{
        SharedData sharedData = new SharedData();

        // create and start threads
        Thread[] threads = new Thread[3];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Incrementer(sharedData));
            threads[i].start();
        }

        // make the main thread wait for thread completion
        for (Thread t : threads) { t.join(); }

        // we should expect the final count to be 3000
        // (Each thread increments thread 1000 times)
        System.out.println(sharedData.getCount());
    }
}
