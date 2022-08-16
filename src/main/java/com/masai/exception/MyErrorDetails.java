package com.masai.exception;

import java.time.LocalDateTime;

public class MyErrorDetails {
    private LocalDateTime time;
    private String msg;
    private String details;
    
	public MyErrorDetails() {
		super();
	}

	public MyErrorDetails(LocalDateTime time, String msg, String details) {
		super();
		this.time = time;
		this.msg = msg;
		this.details = details;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "MyErrorDetails [time=" + time + ", msg=" + msg + ", details=" + details + "]";
	}
	
	
    
    
}
