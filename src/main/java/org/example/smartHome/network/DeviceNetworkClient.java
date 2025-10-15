package org.example.smartHome.network;

import java.io.*;
import java.net.Socket;

public class DeviceNetworkClient {


    private static final String HOST = System.getenv().getOrDefault("DEVICE_SERVER_HOST", "localhost");
    private static final int PORT = 12345;

    // Sends a command to DeviceServer and returns the response
    public static String sendCommand(String command) {
        try (Socket socket = new Socket(HOST, PORT);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {

            writer.write(command);
            writer.newLine();
            writer.flush();

            return reader.readLine(); // SUCCESS or ERROR
        } catch (IOException e) {
            return "ERROR: Unable to connect to DeviceServer";
        }
    }
}
