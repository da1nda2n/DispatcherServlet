package org.example.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientMain {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8080);  // IP주소, 포트번호
        System.out.println("소켓 연결 : " + socket);

        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();

        byte[] buf = new byte[1024]; // 버퍼
        int count;

        while ((count = System.in.read(buf)) != -1) {
            outputStream.write(buf, 0, count); // buf[0]부터 count 개의 바이트를 출력스트림으로 보낸다.
            // 입력스트림으로부터 읽은 바이트들을 매개값으로 주어진 buf에 저장, 실제 읽은 바이트 수 리턴
            count = inputStream.read(buf);
            System.out.write(buf, 0, count);
        }

        outputStream.close();
        System.out.println(socket + ": 연결 종료");
        socket.close();
    }
}
