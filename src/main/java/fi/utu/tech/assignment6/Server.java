package fi.utu.tech.assignment6;

import fi.utu.tech.assignment6.ClientHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        Hub h = new Hub();
        try(ServerSocket serverSocket = new ServerSocket(18112)) {
            while(true) {
                Socket socket = serverSocket.accept();
                new ClientHandler(socket, h).start();
            }
        } catch (IOException | IllegalArgumentException | SecurityException e) {
            e.printStackTrace();
        }

    }
    
}
