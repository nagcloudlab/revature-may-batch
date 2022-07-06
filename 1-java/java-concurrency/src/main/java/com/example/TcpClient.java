package com.example;

import java.io.*;
import java.net.Socket;

public class TcpClient {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 8181);

        try (
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(
                        new OutputStreamWriter(socket.getOutputStream()))) {
            writer.write("hi" + "\n");
            writer.flush();

            String line = "";
            line = reader.readLine();
            System.out.println("~ " + line);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
