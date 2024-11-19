package fi.utu.tech.assignment4;


import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        try(Socket s = new Socket("localhost", 18112)) {
            System.out.println("Yhdistetty palvelimeen");
            OutputStream os = s.getOutputStream();
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(os)), true);
            InputStream is = s.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(is));

            out.println("Hello");
            System.out.println("Hello sent");

            System.out.println("Waiting for response...");
            String response = in.readLine();
            if (!response.isEmpty()) {
                System.out.println("Received: " + response);
                System.out.println("Sending quit");
                out.println("quit");
            }
        } catch (IOException | SecurityException | IllegalArgumentException e) {
            e.printStackTrace();
        }

    }

}
