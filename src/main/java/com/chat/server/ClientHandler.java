package com.chat.server;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );

            PrintWriter output = new PrintWriter(
                    socket.getOutputStream(), true
            );

            output.println("Connected to Real-Time Java Chat Server!");
            output.println("Enter your username:");

            String username = input.readLine();

            output.println("Welcome, " + username + "!");
            output.println("You are now connected to the server.");

        } catch (IOException e) {

            System.out.println(
                    "Client connection error: " + e.getMessage()
            );

        } finally {

            try {
                socket.close();
            } catch (IOException e) {
                System.out.println("Unable to close connection.");
            }
        }
    }
}