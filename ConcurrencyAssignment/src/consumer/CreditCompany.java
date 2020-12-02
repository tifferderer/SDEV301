package consumer;

import shared.Application;
import shared.ApplicationQueue;

/**
 * Represents a credit company
 * @author Tiffany Ferderer
 * @version 1.0
 */
public class CreditCompany implements Runnable {

    private ApplicationQueue mySharedQueue;

    //No magic numbers!
    private final int EMPTY = 0;
    private final int POOR = 580;
    private final int FAIR = 669;
    private final int FAIR_LOAN = 5000;
    private final int GOOD = 739;
    private final int GOOD_LOAN = 10000;
    private final int VERY_GOOD = 799;
    private final int VGOOD_LOAN = 25000;
    private final int EXCEPTIONAL_LOAN = 50000;


    /**
     * Constructs a Credit Company object
     * @param mySharedQueue the shared Blocking Queue
     */
    public CreditCompany(ApplicationQueue mySharedQueue) {
        this.mySharedQueue = mySharedQueue;
    }

    /**
     * Remove applications from the shared queue and process them.
     * Looks at the credit score then determines whether the application
     * is approved for credit, and how much an application can borrow.
     */
    public void run() {
        while (mySharedQueue.removeApplication().getApplicationId() != EMPTY) {
            Application current = mySharedQueue.removeApplication();

            int currentScore = current.getCreditScore();
            if (currentScore > POOR) {
                current.setApproved(true);
                if (currentScore <= FAIR) {
                    current.setApprovedLimit(FAIR_LOAN);
                } else if (currentScore <= GOOD) {
                    current.setApprovedLimit(GOOD_LOAN);
                } else if (currentScore <= VERY_GOOD) {
                    current.setApprovedLimit(VGOOD_LOAN);
                } else {
                    current.setApprovedLimit(EXCEPTIONAL_LOAN);
                }
            }

            if (current.isApproved()) {
                System.out.println(Thread.currentThread().getName() + ": Application #" + current.getApplicationId()
                        + " with credit score " + current.getCreditScore()
                        + " is approved for " + current.getApprovedLimit()
                        + "(requested: " + current.getRequestedLimit() + ").");
            } else {
                System.out.println(Thread.currentThread().getName() + ": Application #" + current.getApplicationId()
                        + " with credit score " + current.getCreditScore()
                        + " is not approved.");
            }
        }
    }
}

