package com.projeto.springboot.spring_boot.entities.enums;

public enum OrderStatus {
	
	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	private int code;
	
	private OrderStatus(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static OrderStatus valueOf(int code) {
		for(OrderStatus cod : OrderStatus.values()) {
			if(cod.getCode() == code) {
				return cod;
			}
		}
		
		throw new IllegalArgumentException("Codigo inválido");
		
	}
	
}
