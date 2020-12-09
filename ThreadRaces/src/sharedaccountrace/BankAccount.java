package sharedaccountrace;
/**
   A bank account has  balance that can be changed by
   deposits and withdrawals.
*/
public class BankAccount
{
   private double balance;

   /**
      Constructs a bank account with a zero balance.
   */
   public BankAccount()
   {
      balance = 0;
   }

   /**
      Deposits money into the bank account.
      @param amount the amount to deposit
   */
   public synchronized void deposit(double amount)
   {
      System.out.print("Depositing " + amount);
      double newBalance = balance + amount;
      System.out.println(", new balance is " + newBalance);
      balance = newBalance;
      notifyAll();
   }
   
   /**
      Withdraws money from the bank account.
      @param amount the amount to withdraw
   */
   public synchronized void withdraw(double amount) {
      try {
         while (balance < amount) {
            wait();
         }
         System.out.print("Withdrawing " + amount);
         double newBalance = balance - amount;
         System.out.println(", new balance is " + newBalance);
         balance = newBalance;
      } catch (InterruptedException e) {
         System.out.println("Interrupted: " + e);
      }
   }
   
   /**
      Gets the current balance of the bank account.
      @return the current balance
   */
   public synchronized double getBalance()
   {
      return balance;
   }
}

