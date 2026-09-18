package com.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    private static final int PORT = 5000;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Chat server started on port " + PORT);

            while (true) {
                try (Socket clientSocket = serverSocket.accept()) {
                    System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());
                }
            }
        } catch (IOException exception) {
            System.err.println("Unable to start or run the chat server: " + exception.getMessage());
        }
    }
}