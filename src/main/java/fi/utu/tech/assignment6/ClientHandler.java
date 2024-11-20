package fi.utu.tech.assignment6;


import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public class ClientHandler extends Thread {

    Socket s;
    Hub hub;

    // Pieni vinkki
    public ClientHandler(Socket s, Hub h) {
        this.hub = h;
        this.s = s;
    }

    public void run() {
        try {
            InputStream is = s.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(is));
            OutputStream os = s.getOutputStream();
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(os)), true);


            String line;
            while ((line = in.readLine()) != null) {
                String[] messageParts = line.split(";");
                String command = messageParts[1];
                if (command.equalsIgnoreCase("OFF") || command.equalsIgnoreCase("ON")) {
                    int lightID = Integer.parseInt(messageParts[2]);
                    if (command.equalsIgnoreCase("OFF")) {
                        hub.turnOffLight(lightID);
                    } else if (command.equalsIgnoreCase("ON")) {
                        hub.turnOnLight(lightID);
                    }
                } else if (command.equalsIgnoreCase("QUERY")) {
                    StringBuilder responseBuilder = new StringBuilder();
                    Collection<Light> lights = hub.getLights();

                    for (Light light : lights) {
                        int id = light.getId();
                        String status = light.isPowerOn() ? "ON" : "OFF";

                        responseBuilder.append(id).append(":").append(status).append(";");
                    }

                    String response = responseBuilder.toString();

                    if (response.endsWith(";")) {
                        response = response.substring(0, response.length() - 1);
                    }
                    out.println(response);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
