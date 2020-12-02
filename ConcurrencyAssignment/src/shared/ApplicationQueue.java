package shared;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Represents a shared queue used by the Applicants
 * and CreditCompany threads.
 */
public class ApplicationQueue {

    private static final int MAX = 100;

    private static BlockingQueue<Application> apps = new ArrayBlockingQueue<>(MAX);

    /**
     * Adds an Application object to the apps queue using the
     * thread-safe ArrayBlockingQueue put() method.
     * The method put() will place an Application at the end
     * of the Blocking Queue and will wait if the queue is full.
     * @param app the Application object
     */
    public void addApplication(Application app) {
        try {
            apps.put(app);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Removes an Application object from the apps queue using
     * the thread-safe ArrayBlockingQueue take() method.
     * The take() method will remove an element from the front
     * of the Blocking Queue, waiting if the queue is empty.
     * @return The Application from the front of the queue.
     */
    public Application removeApplication() {
        try {
            Application app = apps.take();
            return app;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
