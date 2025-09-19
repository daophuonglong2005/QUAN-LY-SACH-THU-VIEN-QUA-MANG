package server;

import server.network.ClientHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {
    public static void main(String[] args) {
        int port = 9999; // có thể đọc từ application.properties
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("📡 Server đang chạy tại cổng " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("✅ Client kết nối: " + clientSocket);
                new ClientHandler(clientSocket).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
