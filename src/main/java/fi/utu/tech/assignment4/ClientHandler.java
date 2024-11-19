package fi.utu.tech.assignment4;


import java.io.*;
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
            BufferedReader in = new BufferedReader(new InputStreamReader(is));
            OutputStream os = s.getOutputStream();
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(os)), true);
            String message;
            while (true) {
                System.out.println("Waiting for message!");
                message = in.readLine();
                System.out.println("Received: " + message);

                if (message.equalsIgnoreCase("quit")) {
                    System.out.println("Closing connection...");
                    break;
                } else if (message.equalsIgnoreCase("Hello")) {
                    out.println("Ack");
                    System.out.println("Sent: Ack");
                }
            }
            s.close();
            System.out.println("Connection closed");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
