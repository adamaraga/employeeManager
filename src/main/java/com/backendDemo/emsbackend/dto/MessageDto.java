package com.backendDemo.emsbackend.dto;
import lombok.Data;

@Data
public class MessageDto {
    private String recipientName;
    private String recipientEmail;
    private String subject;
    private String message;

    @Override
    public String toString() {
        return "MessageDto{" +
                "recipientName='" + recipientName + '\'' +
                ", recipientEmail='" + recipientEmail + '\'' +
                ", subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
