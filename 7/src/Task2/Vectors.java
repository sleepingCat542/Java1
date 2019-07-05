package Task2;

public class Vectors extends Thread{

        int[] v1, v2;
        int index;

        public Vectors(int[] v1, int[] v2, int index){
            this.v1=v1;
            this.v2=v2;
            this.index=index;
        }

        @Override
        public void run() {
            int sum = v1[index]+v2[index];
            Main.result[index]=sum;
            System.out.println("Результат сложения элементов под индексом "+index+" = "+Main.result[index]);
        }
    }



