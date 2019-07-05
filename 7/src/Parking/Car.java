package Parking;

import java.util.Random;

public class Car extends Thread {
    public String carName;
    Parking parking;
    Random random = new Random();

    public Car(int pCarName, Parking pParking) {
        this.carName = String.valueOf(pCarName);
        this.parking = pParking;
        System.out.println("Parking.Car " + this.carName + " sis come");
    }

    @Override
    public void run() {//код который выполняется в потоке
        synchronized (parking) { //Происходит  блокировка  объекта parking и он становится недоступным
                                    // для других синхронизированных методов и блоков
            if (parking.getFreePlace() == -1) {
                int waitingTime = random.nextInt(1000);
                System.out.println("Parking.Car " + this.getCarName() + " is waiting...");
                try{
                    parking.wait(waitingTime);//останавливает выполнение текущего потока и освобождает от блокировки захваченный объект
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
        if(parking.getFreePlace() != -1){
            parking.setCar(this);
            parking.showParking();
            try{
                Thread.sleep(random.nextInt(3000));
            }
            catch(Exception e){
                e.printStackTrace();
            }

            parking.leaveCar(this);
            synchronized (parking){
                parking.notify();  //возвращает блокировку объекта потоку
            }
        }
        else{
            System.out.println("Parking.Car " + this.getCarName() + " left");
        }
    }

    public String getCarName(){
        return this.carName;
    }
}
