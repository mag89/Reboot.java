package client;

import java.io.*;
import java.net.Socket;
import java.util.Optional;

public class Client {

    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 8000);
             OutputStream outputStream = socket.getOutputStream();
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
             BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
             InputStream inputStream = socket.getInputStream();
             InputStreamReader reader = new InputStreamReader(inputStream);
             BufferedReader bufferedReader = new BufferedReader(reader)) {

            String request = "Visaginas";
            bufferedWriter.write(request);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            System.out.println("Request = " + request);

            String response = Optional.ofNullable(bufferedReader.readLine()).orElse("empty response from server");
            System.out.println("Response = " +  response);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
