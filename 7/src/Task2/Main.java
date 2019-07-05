package Task2;

public class Main {
        public static int[] result;
        public static void main(String[] args) throws InterruptedException {
            int[] vector1 = new int[]{4, 5, 1};
            int[] vector2 = new int[]{3, 7, 3};

            int threadCount = vector1.length;
            result = new int[threadCount];
            Vectors[] res= new Vectors[threadCount];
            for (int i=0; i<threadCount;i++){
                res[i]=new Vectors(vector1,vector2, i);
                res[i].start();
            }
            for (Vectors v : res) {
                v.join();
            }
            printVector(result);
        }

        public static void printVector(int[] vector){
            System.out.println("Результат:");
            for (int i=0;i<vector.length;i++){
                System.out.println("\t\t\t"+vector[i]);
            }
        }
    }



