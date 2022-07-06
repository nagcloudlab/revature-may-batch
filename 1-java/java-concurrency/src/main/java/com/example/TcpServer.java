package com.example;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class TcpServer {
    public static void main(String[] args) throws Throwable {
        ServerSocket server = new ServerSocket(); // TCP server
        server.bind(new InetSocketAddress(8181));
        while (true) {
            Socket socket = server.accept();

            // thread pool
            new Thread(clientHandler(socket)).start();

        }
    }
//
    private static Runnable clientHandler(Socket socket) {
        return () -> {
            try (
                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(socket.getInputStream()));
                    PrintWriter writer = new PrintWriter(
                            new OutputStreamWriter(socket.getOutputStream()))) {
                String line = "";
                line = reader.readLine();
                System.out.println("~ " + line);
                TimeUnit.SECONDS.sleep(5);
                writer.write(line.toUpperCase() + "\n");
                writer.flush();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        };
    }
}
