package runnable;

public class CounterRunnable implements Runnable{
    private int low;
    private int high;

    public CounterRunnable(int low, int high) {
        this.low = low;
        this.high = high;
    }

    @Override
    public void run() {
        for (int i = low; i <= high; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new CounterRunnable(20,30));
        thread.start();
    }
}
