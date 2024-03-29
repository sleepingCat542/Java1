package w;

import java.util.Random;
import java.util.concurrent.Semaphore;//поток ожидает завершения действий в других потоках

public class Main {
    public static final int AMOUNT_OF_OPERATORS = 3;
    public static final int AMOUNT_OF_CLIENTS = 10;

    public static void main(String[] args) {
        Random rand = new Random();
        Semaphore semaphore = new Semaphore(AMOUNT_OF_OPERATORS, true);//порядок соот. запросам
        CallCenter callCenter = new CallCenter(AMOUNT_OF_OPERATORS);
        try {
            for (int i = 0; i < AMOUNT_OF_CLIENTS; i++) {
                new Client(callCenter, semaphore, i).start();
                Thread.sleep(rand.nextInt(300) + 300 );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}