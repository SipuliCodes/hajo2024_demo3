package fi.utu.tech.assignment5;

import java.io.*;
import java.net.Socket;
import java.util.List;

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

            String line;
            while ((line = in.readLine()) != null) {
                System.out.println("Waiting for message!");

                String[] messageParts = line.split(";");
                String command = messageParts[1];
                if (command.equalsIgnoreCase("OFF") || command.equalsIgnoreCase("ON")) {
                    int lightID = Integer.parseInt(messageParts[2]);
                    if (command.equalsIgnoreCase("OFF")) {
                        System.out.println("Kytketään valo " + lightID + " POIS");
                    } else if (command.equalsIgnoreCase("ON")) {
                        System.out.println("Kytketään valo " + lightID + " PÄÄLLE");
                    }
                } else if (command.equalsIgnoreCase("QUERY")) {
                    System.out.println("Kyselykomento vastaanotettu");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
