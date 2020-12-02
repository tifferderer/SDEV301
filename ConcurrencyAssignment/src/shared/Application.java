package shared;

/**
 * This class represents a credit application.
 * @author Tiffany Ferderer
 * @version 1.0
 */
public class Application {

    private static int nextId = 10000;

    private int applicationId;
    private int creditScore;
    private int requestedLimit;
    private boolean approved;
    private int approvedLimit;

    /**
     * Constructs a new application instance
     * and assigns an id when created.
     * @param creditScore The credit score of the application
     * @param requestedLimit The amount of credit requested
     */
    public Application(int creditScore, int requestedLimit) {
        //The class constructor should assign the
        // applicationId when the application is created. The remaining
        // instance fields should be left at their default values.
        this.creditScore = creditScore;
        this.requestedLimit = requestedLimit;
        applicationId = getNextId();
    }

    //Getters
    /**This static method increments the nextId field.
     *Be sure to access nextId in a static, thread-safe way.
     * @return the value of the field prior to being incremented
     */
    public static synchronized int getNextId() {
        int currentId = nextId;
        nextId++;
        return currentId;
    }

    /**
     * Get the Application ID
     * @return application ID
     */
    public int getApplicationId() {
        return applicationId;
    }

    /**
     * Get the credit score
     * @return credit score
     */
    public int getCreditScore() {
        return creditScore;
    }

    /**
     * Get the requested limit
     * @return requested limit
     */
    public int getRequestedLimit() {
        return requestedLimit;
    }

    /**
     * Get the Approval
     * @return if application is approved for credit
     */
    public boolean isApproved() {
        return approved;
    }

    /**
     * Get the Approved Limit
     * @return approved credit limit
     */
    public int getApprovedLimit() {
        return approvedLimit;
    }

    //Setters
    /**
     * Set the credit score
     * @param creditScore credit score
     */
    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    /**
     * Set the requested limit
     * @param requestedLimit limit requested
     */
    public void setRequestedLimit(int requestedLimit) {
        this.requestedLimit = requestedLimit;
    }

    /**
     * Set Approval
     * @param approved boolean approval
     */
    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    /**
     * Set the approved limit
     * @param approvedLimit approved limit
     */
    public void setApprovedLimit(int approvedLimit) {
        this.approvedLimit = approvedLimit;
    }
}