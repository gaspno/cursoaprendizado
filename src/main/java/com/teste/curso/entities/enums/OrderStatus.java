package com.teste.curso.entities.enums;

public enum OrderStatus {
	WAITING_PAYMENT(1),PAID(2),SHIPPED(3),DELIVERED(4),CANCELED(5);

	private int CODE;
	
	private OrderStatus(int code) {
		this.CODE=code;
	}
	public int getCode() {
		return CODE;
	}
	public static OrderStatus valueOf(int code) {
		
		for(OrderStatus value: OrderStatus.values()) {
			if(value.getCode()==code)
				return value;
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
}
