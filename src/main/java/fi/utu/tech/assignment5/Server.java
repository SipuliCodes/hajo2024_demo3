package fi.utu.tech.assignment5;

import fi.utu.tech.assignment5.ClientHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(18112)) {
            while(true) {
                Socket socket = serverSocket.accept();
                new ClientHandler(socket).start();
            }
        } catch (IOException | IllegalArgumentException | SecurityException e) {
            e.printStackTrace();
        }

    }
    
}
