package runnablelambda;

public class CounterLambda {
    public static void main(String[] args) {
        final int LOW = 45;
        final int HIGH = 55;

        Runnable r = () -> {
            for (int i = LOW; i <= HIGH; i++) {
                System.out.println(i);
            }
        };

        Thread thread = new Thread(r);
        thread.start();
    }
}
