package fi.utu.tech.assignment1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(18112);) {
            Socket socket = serverSocket.accept();
            System.out.println("Asiakas yhdistänyt");
            socket.close();
        } catch (IOException | IllegalArgumentException | SecurityException e) {
            e.printStackTrace();
        }
    }
    
}
