package fi.utu.tech.assignment3;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        try(Socket s = new Socket("localhost", 18112);) {
            System.out.println("Yhdistetty palvelimeen");
            String message = "Hello";
            OutputStream os = s.getOutputStream();
            os.write(message.getBytes());
            System.out.println("Kirjoitettu palvelimelle " + message);

        } catch (IOException | SecurityException | IllegalArgumentException e) {
            e.printStackTrace();
        }

    }

}
