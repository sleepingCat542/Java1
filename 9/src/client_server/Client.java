package client_server;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = null;
        BufferedReader br = null;
        try {
            socket = new Socket(InetAddress.getLocalHost(), 7071);
            br = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
            PrintStream ps = new PrintStream(socket.getOutputStream());
            Scanner scan = new Scanner(System.in);
            System.out.println("Угадайте число от 0 до 9");
            int dig;
            for(int i=0;i<3;i++) {
                dig = scan.nextInt();
                ps.println(dig);
                System.out.println(br.readLine());
            }
        } catch (Exception ex) {
            System.out.println();
        }
    }
}