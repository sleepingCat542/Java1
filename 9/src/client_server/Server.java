package client_server;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args){
        try {
            ServerSocket server = new ServerSocket(7071);
            System.out.println("Wait connections...");
            while (true) {
                Socket socket = server.accept();
                System.out.println(socket.getInetAddress() + " connected");

                ClientThread thread = new ClientThread(socket);
                thread.start();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
