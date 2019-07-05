package client_server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Random;

public class ClientThread extends Thread {

    private PrintStream os;
    private BufferedReader is;
    private InetAddress addr;

    public ClientThread(Socket s) throws IOException {
        os = new PrintStream(s.getOutputStream());
        is = new BufferedReader(new InputStreamReader(s.getInputStream()));
        addr = s.getInetAddress();
    }

    public void run() {
        Random rand = new Random();
        int i = rand.nextInt() % 10;
        if(i<0)
            i*=-1;
        System.out.println(i);
        int counter = 3;
        boolean key = false;
        String str;
        try {
            while (!key) {
                str = is.readLine();
                if(i == Integer.valueOf(str)){
                    os.println("вы угадали число");
                    key = true;
                }
                else{
                    counter--;
                    os.println("У вас осталось " + counter + " попыток");
                }
                if(counter == 0)
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            disconnect();
        }
    }

    public void disconnect(){
        try {
            if (os != null)
                os.close();
            if (is != null)
                is.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            this.interrupt();
        }
    }

}