package com.diamond.AkiraBACKEND.model;

import java.io.Serializable;

public class PaymentMethod implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String paymentMethod;


	public String getPaymentMethod() {
		return paymentMethod;
	}


	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
