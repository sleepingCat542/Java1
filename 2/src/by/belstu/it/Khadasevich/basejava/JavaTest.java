package by.belstu.it.Khadasevich.basejava;
import static java.lang.Math.*;

public class JavaTest {
    static int sint;
    final int ZE = 123;
    public final int ZEZE = 456;
    public static final int ZEZEZE = 789;

    public static void main(String[] args) {

        System.out.println("Exercise B");
            char pchar = 'x';   //B
            int pint = 123;
            short pshort = 12;
            byte pbyte = 35;
            long plong = 789L;
            boolean pbool = true;
            System.out.println("kyky" + pint);
            System.out.println("kyky" + pchar);
            System.out.println("kyky" + 123.456);
            byte nbyte;
            nbyte = (byte) (pbyte + pint);
            System.out.println("byte=byte+int" + nbyte);
            int rint = (int) (123.456D + (double) plong);
            System.out.println("int=double+long  " + rint);
            long l=45664564575675756L;
            long l2=(long)2+l;
            long rlong = (long) (pint + 2147483647);
            System.out.println("plong=pint+2147483647    " + rlong);
            System.out.println("sint=" + sint);
            boolean abool = pbool && pbool;
            System.out.println("boolean=boolean&&boolean  " + abool);
            boolean obool = pbool ^ pbool;
            System.out.println("boolean=boolean^boolean   " + obool);
            long num = 9223372036854775807L;
            long num2 = 8796093022207L;
            char zu = 97;
            System.out.println(zu);
            char zuzu = '\u0061';
            System.out.println(zuzu);
            char zuzuzu = 'a';
            System.out.println(zuzuzu);
            System.out.println((char) (zu + zuzu + zuzuzu));
            System.out.println("3.45%2.4=1.0500000000000003");
            System.out.println("1.0/0.0=Infinity");
            System.out.println("0.0/0.0=NaN");
            System.out.println("log(-345)=" + Math.log(-345.0D));
            System.out.println(Float.intBitsToFloat(2139095040));
            System.out.println(Float.intBitsToFloat(-8388608));



            System.out.println("Exercise D");
            System.out.println(PI);
            System.out.println(E);
            long opi = Math.round(PI);
            System.out.println("Round(PI)=" + opi);
            long oe = Math.round(E);
            System.out.println("Round(E)=" + oe);
            System.out.println("Min(PI, E)=" + Math.min(opi, oe));
            System.out.println("random=" + Math.random() * 1);



        System.out.println("Exercise E");
        Character oChar = 'a';
        Integer oInt = 10;
        Short oShort = 2;

        Long oLOng = 12345678901L;
        Double oDouble =123.456D;
        Byte by=2;
        Boolean boo=true;
        int nInt = ~oInt;
        System.out.println("~Integer=" + nInt);
        char ze = 98;
        ze = (char) (ze + oChar);
        System.out.println("+Char=" + ze);
        int ne = oShort >> 2;
        System.out.println(ne);
        int be = oShort >>> 2;
        System.out.println(be);
        long lo = oLOng & 111L;
        System.out.println("Long&111=" + lo);
        System.out.println("longMIN=" + Long.MIN_VALUE);
        System.out.println("longMAX=" + Long.MAX_VALUE);
        System.out.println("doubleMIN=" + Double.MIN_VALUE);
        System.out.println("doubleMAX=" + Double.MAX_VALUE);
        Integer zint = 123;
        int a = zint;
        Byte zbyte = 2;
        byte zer = zbyte;
        int x = Integer.parseInt("9");
        System.out.println(x);
        System.out.println(Integer.toHexString(10));
        System.out.println(Integer.compare(10, 2));
        System.out.println(Integer.toString(123, 2));




        System.out.println("Exercise F");
        String s34 = "2345";
        int l5=Integer.valueOf(s34);
        System.out.println(l5);
        int l7=Integer.parseInt(s34);
        Integer kek = new Integer(s34);//?
        System.out.println(kek);
        byte[] nen = s34.getBytes();
        System.out.println(nen);
        String news34 = new String(nen);
        System.out.println(news34);
        System.out.println(Boolean.valueOf(s34));
        System.out.println(Boolean.getBoolean(s34));
        String str1 = "Hello";
        String str2 = "Hello";
        System.out.println("-------------");
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));
        System.out.println(str1.compareTo(str2));
        str2 = null;
        System.out.println(str1 == str2);
        String str = new String("hello my dear friends");
        String[] var8 = str.split(" ");
        int var9 = var8.length;

        System.out.println(str.contains("my"));
        System.out.println(str.hashCode());
        System.out.println(str.indexOf("my"));
        System.out.println(str.length());
        System.out.println(str.replace("friends", "frd"));






        System.out.println("Exercise G");
        int[] zed = new int[0];
        char[][] c1 = new char[3][];
        System.out.println(c1.length);
        int[][] c2 = new int[][]{{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};
        int[][] c3 = new int[][]{{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};
        boolean comRez = c2 == c3;
        System.out.println(comRez);
        int[][] var6 = c3;
        int var7 = c3.length;

        for(int var12 = 0; var12 < var7; ++var12) {
            int[] z2 = var6[var12];
            int[] var10 = z2;
            int var11 = z2.length;

            for(int var13 = 0; var13 < var11; ++var13) {
                int z = var10[var13];
                System.out.println(z);
            }
        }
        }
    }

