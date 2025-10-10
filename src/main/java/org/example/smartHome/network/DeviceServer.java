package org.example.smartHome.network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class DeviceServer {

    public static void main(String[] args) {
        int port = 12345;
        System.out.println("DeviceServer started on port " + port);

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                Socket client = serverSocket.accept();
                new Thread(() -> handleClient(client)).start();
            }
        } catch (IOException e) {
            System.out.println("Error starting server: " + e.getMessage());
        }
    }

    private static void handleClient(Socket client) {
        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()))
        ) {
            String command = in.readLine();
            System.out.println("Received command: " + command);

            if (command != null && command.startsWith("CHANGE_STATUS")) {
                out.write("SUCCESS");
                out.newLine();
                out.flush();
            } else {
                out.write("ERROR: Invalid Command");
                out.newLine();
                out.flush();
            }
        } catch (IOException e) {
            System.out.println("Client handler error: " + e.getMessage());
        }
    }
}
