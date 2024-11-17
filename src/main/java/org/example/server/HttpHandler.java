package org.example.server;

public class HttpHandler {

    // POST
    public String handlePost(String message) {
        return "Created: " + message;
    }

    // GET
    public String handleGet(String message) {
        return "Sample Data: " + message;
    }

    // PUT
    public String handlePut(String message) {
        return "Updated: " + message;
    }

    // DELETE
    public String handleDelete(String message) {
        return "Deleted: " + message;
    }

    //GET /user/{id}
    public String handleGetUser(String message) {
        return "User Information: " + message;
    }

    //POST /user
    public String handlePostUser(String message) {
        return "Created User: " + message;
    }

    //PUT /user/{id}
    public String handlePutUser(String message) {
        return "Updated User: " + message;
    }

    //DELETE /user/{id}
    public String handleDeleteUser(String message) {
        return "Deleted User: " + message;
    }
}