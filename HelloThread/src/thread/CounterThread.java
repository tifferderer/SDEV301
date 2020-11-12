package thread;

public class CounterThread extends Thread{
    private int low;
    private int high;

    public CounterThread(int low, int high) {
        //what call is made here automatically?
        //super();
        this.low = low;
        this.high = high;
    }

    @Override
    public void run() {
        for (int i = low; i < high; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        //construct a counter thread
        CounterThread thread = new CounterThread(5, 10);

        thread.start();
        System.out.println(thread.getName());
        System.out.println("Priority: " + thread.getPriority());
    }
}
