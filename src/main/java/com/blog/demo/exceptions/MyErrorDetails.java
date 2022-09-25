package com.blog.demo.exceptions;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyErrorDetails {
	private LocalDateTime timestamp;
	private String message;
	private String details;
}
