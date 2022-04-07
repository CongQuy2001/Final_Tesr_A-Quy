package com.example.Dto;

import lombok.Data;

@Data
public class ResponseDTO {
	private String code;
	private String massage;
	private Object data;
}
