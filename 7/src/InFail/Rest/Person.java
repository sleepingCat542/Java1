package InFail.Rest;

import java.util.concurrent.Semaphore;

public class Person extends Thread {
    Semaphore sem;
    int id;
    Person(Semaphore sem, int id){
        this.sem=sem;
        this.id=id;
    }

    public void run(){
        try{
            sem.acquire();  // уменьшение счетчика
            System.out.println("Person "+id+" sat at the table ");
            sleep(500);
            System.out.println("Person "+id+" coming from the table ");
            sem.release();  // увеличение счетчика
            sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
