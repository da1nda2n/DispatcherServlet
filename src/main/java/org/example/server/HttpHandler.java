package org.example.server;

import java.util.function.Function;

public class HttpHandler implements Function<String, String> {

    public String handlePost(String message) {
        return "201 Created: " + message;
    }

    public String handleGet(String message) {
        return "200 OK: Sample Data";
    }

    public String handlePut(String message) {
        return "200 OK: Updated Data - " + message;
    }

    public String handleDelete(String message) {
        return "200 OK: Deleted successfully";
    }

    @Override
    public String apply(String message) {
        // 기본적으로 GET 요청을 처리
        return handleGet(message);
    }
}
