package com.example.Entity;

import javax.persistence.Entity;

import lombok.Data;
@Data
public class ErrorMessage {
private String code;
private String message;
}
