package fi.utu.tech.assignment3;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ClientHandler extends Thread {
    Socket s;
    public ClientHandler(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        try {
            InputStream is = s.getInputStream();
            System.out.println(new String(is.readAllBytes()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
