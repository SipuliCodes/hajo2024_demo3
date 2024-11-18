package fi.utu.tech.assignment2;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(18112);) {
            Socket socket = serverSocket.accept();
            System.out.println("Asiakas yhdistänyt");
            InputStream is = socket.getInputStream();
            System.out.println("Asiakas sanoo: " + new String(is.readAllBytes()));
            socket.close();
        } catch (IOException | IllegalArgumentException | SecurityException e) {
            e.printStackTrace();
        }
    }

}
