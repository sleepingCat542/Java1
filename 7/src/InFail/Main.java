package InFail;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Resource resource = null;
        try{
            resource = new Resource("H:\\Технологии программирования в Internet\\Лабы\\Lab7\\notes.txt");
            SyncThread t1 = new SyncThread("A",resource);
            SyncThread t2 = new SyncThread("B",resource);
            SyncThread t3 = new SyncThread("C",resource);
            t1.start();
            t2.start();
            t3.start();
            t1.join();
            t2.join();
            t3.join();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            resource.close();
        }
    }
}
