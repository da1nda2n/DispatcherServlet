package org.example;

import java.io.*;
import java.net.*;

public class DispatcherServlet {

    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        // 클라이언트 연결 대기
        while (true) {
            Socket clientSocket = serverSocket.accept();

            System.out.println("Client connected");
        }
    }
}
