package by.belstu.it.Khadasevich;

public class TextFunction
{
    public TextFunction() { }
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getValue()
        {
            return "Hello from first project";
        }
    public void onCreate()    {
        for (int j = 0; j < 7; j++)
        {
            System.out.println("Counter   " + j);
        }
    }

}
