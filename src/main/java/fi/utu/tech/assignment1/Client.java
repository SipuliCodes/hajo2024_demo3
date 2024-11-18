package fi.utu.tech.assignment1;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public static void main(String[] args) {
        try(Socket s = new Socket("localhost", 18112);) {
            System.out.println("Connected");
        } catch (IOException | SecurityException | IllegalArgumentException e) {
            e.printStackTrace();
        }

    }

}
