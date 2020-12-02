package producer;

import shared.Application;
import shared.ApplicationQueue;

import java.util.Random;

/**
 * This class represents an Applicant containing many applications
 * @author Tiffany Ferderer
 * @version 1.0
 */
public class Applicants implements Runnable{

    private ApplicationQueue mySharedQueue;

    private final int CREDIT_BASE = 300;
    private final int CREDIT_RANGE = 550;
    private final int LIMIT_BASE = 5000;
    private final int LIMIT_RANGE = 45000;
    private final int WAIT_BASE = 100;
    private final int WAIT_RANGE = 1100;

    /**
     * Applicant constructor
     * @param mySharedQueue the queue that is shared
     */
    public Applicants(ApplicationQueue mySharedQueue) {
    this.mySharedQueue = mySharedQueue; }

    /**
     * Create credit applications and add to the shared Blocking
     * Queue. Displays message when an application is created.
     */
    public void run() {
        Random generate = new Random();

        try {
            // The thread should continuously produce
            // applications for a period of three minutes.

            //If every thread takes .5 seconds(500 milliseconds), then I will need
            //to produce( 2(per second) * 60 (seconds in a minute) * 3 (minutes)
            int sleepingPeriod = 500;
            int amountOfApplications = 360;

            for (int i = 1; i <amountOfApplications ; i++) {
                Application client = new Application(
                        generate.nextInt(CREDIT_RANGE)+CREDIT_BASE,
                        generate.nextInt(LIMIT_RANGE)+LIMIT_BASE);

                mySharedQueue.addApplication(client);
                System.out.println(Thread.currentThread().getName() + ": created application #" + client.getApplicationId());
                Thread.sleep(sleepingPeriod);

                //Then, "flip a coin" to decide whether to delay
                // the thread before creating another application.
                // If a delay is indicated, randomly generate a
                // delay time between 100 - 1200ms, then cause the
                // thread to sleep that amount of time before continuing on.
                int coinSides = 2;
                int callHeads = 0;

                int coinFlip = generate.nextInt();

                if(coinFlip % coinSides == callHeads) {
                    Thread.sleep(generate.nextInt(WAIT_RANGE) +WAIT_BASE);
                }
            }
        }catch (InterruptedException e) {
            System.out.println("Interrupted " + e);
        }
        System.out.println(Thread.currentThread().getName() + " finished!");
    }
}