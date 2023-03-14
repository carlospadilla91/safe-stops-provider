package com.safeStopsProvider.SafeStopsProvider.exception;

public class NotFoundException extends RuntimeException {
	
	private String type;
	private Long id;
	
	public NotFoundException() {}
	
	public NotFoundException(String type, Long id) {
		this.type = type;
		this.id = id;
	}
	
	public String getType() {
		return type;
	}
	
	public Long getId() {
		return id;
	}

}
