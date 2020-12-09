package sharedcounterrace;

public class Incrementer implements Runnable {

    private SharedData data;

    public Incrementer(SharedData data){

        this.data = data;

    }

    public void run() {
        for (int i = 1; i <= 1000 ; i++) {
            data.increment();
        }
    }
}
