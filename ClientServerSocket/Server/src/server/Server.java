package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Optional;
import java.util.Random;

public class Server {
    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(8000)) {
            System.out.println("Server started");

            while (true) {
                try (Socket socket = serverSocket.accept();
                     OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream());
                     BufferedWriter bufferedWriter = new BufferedWriter(writer);
                     InputStreamReader reader = new InputStreamReader(socket.getInputStream());
                     BufferedReader bufferedReader = new BufferedReader(reader)) {

                    System.out.println("Client connected");


                    String request = Optional.ofNullable(bufferedReader.readLine()).orElse("empty request from client");
                    System.out.println("request = " + request);

                    String response = String.valueOf(new Random().nextInt(request.length()) * 30 - 10);
                    System.out.println("response = " + response);

                    bufferedWriter.write(response);
                    bufferedWriter.newLine();
                    bufferedWriter.flush();

                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e); //прокидываем unchecked исключение наверх
        }


    }
}
