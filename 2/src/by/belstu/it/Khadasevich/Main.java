package by.belstu.it.Khadasevich;
import by.belstu.it.Khadasevich.TextFunction;

/** @author yuliana
 *  @version 11.2*/

public class Main {
    public static void main(String[] args) {
        /** @throws not
         @return nothing*/
            /** @value TextFunc
             *  @see  hello
             *  @param arg String[] */
            System.out.println("Hello,World!");
            TextFunction obj = new TextFunction();

            Wow();

            for (int i = 0; i < 9; i++) {
                if (i > -1 && i < 10) System.out.println(i);
            }
        }

        private static void Wow() {
            System.out.println("Умножение" + (4 * 5));
        }
    }



