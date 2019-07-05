package by.belstu.it.Khadasevich;

import java.util.Objects;

public class WrapperString {




    private String s1;

    @Override
    public String toString() {
        return "WrapperString{" +
                "s1='" + s1 + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WrapperString that = (WrapperString) o;
        return Objects.equals(s1, that.s1);
    }

    @Override
    public int hashCode() {
        return Objects.hash(s1);
    }

    public void setS1(String s1) {
        this.s1 = s1;
    }

    public String getS1() {
        return s1;
    }

    public WrapperString(String s1) {
        this.s1 = s1;
    }

    public void replace (char oldchar, char newchar) {
        this.replace(oldchar, newchar);
    }

    public static void main(String[] args) {
        String s3=new String("Привет!");
        s3.replace("При", "От" );
    }



   /* WrapperString mystr = new WrapperString("Lol")
    {
        public WrapperString delete (char newChar)
        {
            String newstr = getStr().replace(newChar , '\u0000');
            System.out.print("String after delete symbol: ");
            System.out.println(newstr);
            WrapperString myst = new WrapperString(newstr)
            {
                public void replace (char oldChar , char newChar)
                {
                    String newstr = getStr().replace(newChar, oldChar);
                    System.out.print("String after replace symbol : ");
                    System.out.println(newstr);
                }
            };
            return myst;
        }
    }.delete('a');
mystr.replace('m','l');*/
}
