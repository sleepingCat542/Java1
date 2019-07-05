package InFail.Rest;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        int n = 7;
        Semaphore sem = new Semaphore(3);
        for (int i=1;i<n;i++){
            new Person(sem,i).start();
        }
    }
}
