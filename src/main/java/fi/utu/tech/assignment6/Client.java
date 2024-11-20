package fi.utu.tech.assignment6;


import java.io.*;
import java.net.Socket;
import java.util.Random;

public class Client {

    public static void main(String[] args) {
        try(Socket s = new Socket("localhost", 18112)) {
            System.out.println("Yhdistetty palvelimeen");
            OutputStream os = s.getOutputStream();
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(os)), true);
            InputStream is = s.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(is));

            Random random = new Random();

            for (int i = 0; i < 100; i++) {
                int commandType = random.nextInt(3);
                int lightID = random.nextInt(5);
                Thread.sleep(1000);
                switch (commandType) {
                    case 0:
                        out.println("LIGHT;ON;" + lightID);
                        break;
                    case 1:
                        out.println("LIGHT;OFF;" + lightID);
                        break;
                    case 2:
                        out.println("LIGHT;QUERY");
                        System.out.println(in.readLine());
                        break;
                }
            }

        } catch (IOException | SecurityException | IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
