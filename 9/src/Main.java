import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;


public class Main {

    public static void main(String[] args) {
//        System.out.println("First task on RxJava");
//        BehaviorSubject<Integer> a = BehaviorSubject.create(); // хранит только последнее значение
//        BehaviorSubject<Integer> b = BehaviorSubject.create();
//        Observable<Integer> c = Observable.combineLatest(a,b,(i1, i2) -> i1+i2); // источник данных
//        c.subscribe (System.out::println); // подписка позволяет печатать в основной поток вывода
//        a.onNext(10); // порция данных
//        b.onNext(10);
//        a.onNext(20);
//
//        System.out.println("Second task on RxJava");
//        Observable<Integer> cIn2 = c.map(i->i*i); // может порождать данные другого типа
//        cIn2.subscribe (System.out::println);
//        a.onNext(1);
//        b.onNext(2);
//        a.onNext(4);
//        Observable<Integer> cEven = c.filter(i->i%2==0); // фильтрует данные по условию
//        cEven.subscribe (System.out::println);


        System.out.println("Web programming");
        WorkWithSite worker = new WorkWithSite();
        worker.getLocalHost();
        worker.getByName("www.belstu.by");
        byte ip[] = {(byte)127,(byte)0,(byte)0,(byte)7};
        worker.getByAdress("Unknown",ip);
        //worker.ReadHTML("https://www.tut.by");
        worker.getInfo("https://www.tut.by");

        WorkWithSite w2 = new WorkWithSite();
        w2.getInfo("file:///H:/index.html");
        w2.ReadHTML("file:///H:/index.html");
        System.out.println();
        w2.ReadHTML("file:///index2.jsp");
    }
}
