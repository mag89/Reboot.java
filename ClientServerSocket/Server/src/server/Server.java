package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class Server {
    private static final Object lock = new Object();

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(8000)) {
            System.out.println("Server started");

            while (true) {
                Socket socket = serverSocket.accept();
                OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream());
                BufferedWriter bufferedWriter = new BufferedWriter(writer);
                InputStreamReader reader = new InputStreamReader(socket.getInputStream());
                BufferedReader bufferedReader = new BufferedReader(reader);

                System.out.println("Client connected");

                new Thread(() -> {
                    try {
                        String request = Optional.ofNullable(bufferedReader.readLine())
                                .orElse("empty request from client");

                        System.out.println("request = " + request);

                        String response = String.valueOf(new Random()
                                .nextInt(request.length()) * 30 - 10);

                        try {
                            Thread.sleep(4000);
                        } catch (InterruptedException e) {
                            closeResources(Arrays.asList(bufferedReader, bufferedWriter, socket));
                        }

                        System.out.println("response = " + response);
                        bufferedWriter.write(response);
                        bufferedWriter.newLine();
                        bufferedWriter.flush();

                        closeResources(Arrays.asList(bufferedReader, bufferedWriter, socket));

                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e); //прокидываем unchecked исключение наверх
        }
    }


    private static void closeResources(List<Closeable> l) {
        l.stream().forEach(x -> {
            try {
                x.close();
            } catch (IOException e) {
                throw new RuntimeException();
            }
        });
    }
}
