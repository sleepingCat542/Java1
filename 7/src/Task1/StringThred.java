package Task1;

public class StringThred {

    public static int counter = 0;

    public static void main(String args[]) {
        final StringBuilder s = new StringBuilder();
        new Thread() {

            public void run() {
                synchronized (s) {
                    do {
                        System.out.println("1 begin");
                        s.append("Т");
                        System.out.println("1 working");
                        System.out.println("1 wait");
                        try {
                            s.wait(40);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } while (StringThred.counter++ < 3);
                    System.out.println("1 end");
                }
            }
        }.start();
        new Thread() {
            public void run() {
                synchronized (s) {
                    while (StringThred.counter++ < 3) {
                        System.out.println("2 begin");
                        s.append("О");
                        System.out.println("2 working");
                        System.out.println("2 wait");
                        try {
                            s.wait(25);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("2 end");
                }
            }
        }.start();
        new  Thread() {
            public void run() {
                synchronized (s) {

                    while (StringThred.counter++ < 3) {
                        System.out.println("3 begin");
                        s.append("К");
                        System.out.println("3 working");
                        System.out.println("3 wait");
                        try {
                            s.wait(30);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("3 end");
                }
            }
        }.start();
//        new  Thread() {
//            public void run() {
//                synchronized (s) {
//                        System.out.println(s);
//                        try {
//                            s.wait(60);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                }
//            }
//        }.start();
    }
}

