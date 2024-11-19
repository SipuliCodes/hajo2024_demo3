package fi.utu.tech.assignment5;

import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        try(Socket s = new Socket("localhost", 18112)) {
            System.out.println("Yhdistetty palvelimeen");
            OutputStream os = s.getOutputStream();
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(os)), true);

            out.println("LIGHT;ON;3");
            out.println("LIGHT;OFF;4");
            out.println("LIGHT;QUERY");


        } catch (IOException | SecurityException | IllegalArgumentException e) {
            e.printStackTrace();
        }

    }

}
