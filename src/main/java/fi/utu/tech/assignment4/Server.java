package fi.utu.tech.assignment4;

import fi.utu.tech.assignment4.ClientHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(18112)) {
            while(true) {
                Socket socket = serverSocket.accept();
                System.out.println("Asiakas yhdistänyt");
                ClientHandler clientHandler = new ClientHandler(socket);
                System.out.println("Luotiin uusi clienthandleri");
                clientHandler.start();
                System.out.println("Käynnistettiin clienthandleri");
            }
        } catch (IOException | IllegalArgumentException | SecurityException e) {
            e.printStackTrace();
        }
    }

}
