package org.example.server;

import org.example.client.ClientHandler;

import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class DispatcherServlet {

    private static final int PORT = 8080;

    private Map<String, Function<String, String>> handlers = new HashMap<>();

    public void addHandler(String key, Function<String, String> handler) {
        handlers.put(key, handler);
    }

    public String doDispatch(String message) {
        String[] requestParts = message.split("\n");
        String[] requestLineParts = requestParts[0].split(" ");
        String method = requestLineParts[0]; // HTTP 메서드
        String path = requestLineParts[1];   // 경로

        String key = method + " " + path;

        Function<String, String> handler = handlers.get(key);

        //핸들러 찾기
        if (handler != null) {
            return handler.apply(message);
        } else {
            return "404 Not Found";
        }
    }
}