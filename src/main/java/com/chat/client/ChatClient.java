package com.chat.client;

import java.io.*;
import java.net.Socket;

public class ChatClient {

    public static void main(String[] args) {

        String serverAddress = "127.0.0.1";
        int port = 5000;

        try {

            Socket socket = new Socket(serverAddress, port);

            System.out.println("Connected to Chat Server!");

            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );

            PrintWriter output = new PrintWriter(
                    socket.getOutputStream(), true
            );

            System.out.println(input.readLine());
            System.out.println(input.readLine());

            output.println("Arshiya");

            System.out.println(input.readLine());
            System.out.println(input.readLine());

            BufferedReader keyboard = new BufferedReader(
                    new InputStreamReader(System.in)
            );

            System.out.println("Type a message:");

            String message = keyboard.readLine();

            output.println(message);

            System.out.println(input.readLine());

            socket.close();
        } catch (IOException e) {

            System.out.println(
                    "Client error: " + e.getMessage()
            );
        }
    }
}