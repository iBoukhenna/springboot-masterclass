package com.dzcode.springboot.masterclass.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessage {
    private int code;
    private String message;
}
