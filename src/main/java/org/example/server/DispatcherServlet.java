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

    public DispatcherServlet() {
        // HttpHandler를 Function으로 래핑하여 Map에 추가
        handlers.put("POST", new HttpHandler()::handlePost);
        handlers.put("GET", new HttpHandler()::handleGet);
        handlers.put("PUT", new HttpHandler()::handlePut);
        handlers.put("DELETE", new HttpHandler()::handleDelete);
    }

    public String doDispatch(String message) {
        String[] requestParts = message.split("\n");
        String method = requestParts[0].split(" ")[0];  // 예: "POST / HTTP/1.1"

        if (handlers.containsKey(method)) {
            return handleRequest(method, message);
        } else {
            return "405 Method Not Allowed";
        }
    }

    private String handleRequest(String method, String message) {
        Function<String, String> handler = handlers.get(method);
        return handler.apply(message);  // 핸들러 호출
    }
}