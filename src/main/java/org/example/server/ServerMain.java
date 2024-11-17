package org.example.server;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;
import java.io.OutputStream;

public class ServerMain {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);  // 포트번호
        System.out.println("소켓 생성");

        DispatcherServlet dispatcherServlet = new DispatcherServlet();

        while (true) {
            Socket socket = serverSocket.accept();

            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();

            byte[] inputData = new byte[100];
            int length;

            while ((length = in.read(inputData)) != -1) {
                String inputMessage = new String(inputData, 0, length);
                String outputMessage = dispatcherServlet.doDispatch(inputMessage);
//                String outputMessage = "TEST";
                out.write(outputMessage.getBytes());
            }
            out.flush();

            socket.close();
        }
    }
}