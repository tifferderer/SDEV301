package driver;

import consumer.CreditCompany;
import producer.Applicants;
import shared.ApplicationQueue;

/**
 * Driver program that will create an instance of ApplicationQueue
 * class, which it will pass to producer (Applicants) and consumer
 * (CreditCompany) threads as a parameter to the constructor methods.
 * @author Tiffany Ferderer
 * @version 1.0
 */
public class TestCreditApplication {

    /**
     * Driver program
     * @param args Command line arguments
     */
    public static void main(String[] args) {

        ApplicationQueue driver = new ApplicationQueue();

        /*  Part One
        Thread p = new Thread(new Applicants(driver));
        p.setName("P1");
        System.out.println(p.getName() +  " started.");
        p.start();

        Thread c = new Thread(new CreditCompany(driver));
        c.setName("C1");
        c.start();
         */

        for (int i = 1; i <= 3; i++) {
            Thread p = new Thread(new Applicants(driver));
            p.setName("P"+ i);
            System.out.println(p.getName()+ " started.");
            p.start();
        }

        for (int i = 1; i <=2 ; i++) {
            Thread c = new Thread(new CreditCompany(driver));
            c.setName("C" + i);
            c.start();
        }
    }
}
