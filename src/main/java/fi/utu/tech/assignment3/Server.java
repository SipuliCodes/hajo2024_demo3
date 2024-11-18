package fi.utu.tech.assignment3;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(18112);) {
            while(true) {
                Socket socket = serverSocket.accept();
                System.out.println("Asiakas yhdistänyt");
                new ClientHandler(socket).start();
            }
        } catch (IOException | IllegalArgumentException | SecurityException e) {
            e.printStackTrace();
        }

    }

}
