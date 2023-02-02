package com.example.hospital.response;

public class ResponseMessage {
    private String message;

    // new code started

    private String fileId;

    public ResponseMessage(String message, String fileId) {
        this.message = message;
        this.fileId = fileId;
    }

    // new code ended

    public ResponseMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }


}
