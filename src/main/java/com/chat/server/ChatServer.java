package com.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

    public static void main(String[] args) {

        int port = 5000;

        try (ServerSocket serverSocket = new ServerSocket(port)) {

            System.out.println("=================================");
            System.out.println("     REAL-TIME JAVA CHAT");
            System.out.println("=================================");
            System.out.println("Server started on port " + port);
            System.out.println("Waiting for clients...");

            while (true) {

                Socket clientSocket = serverSocket.accept();

                System.out.println("New client connected!");

                ClientHandler clientHandler =
                        new ClientHandler(clientSocket);

                Thread clientThread =
                        new Thread(clientHandler);

                clientThread.start();
            }

        } catch (IOException e) {

            System.out.println(
                    "Server error: " + e.getMessage()
            );
        }
    }
}