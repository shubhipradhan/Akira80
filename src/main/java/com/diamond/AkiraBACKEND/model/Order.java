package com.diamond.AkiraBACKEND.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Order")
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String userId;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String orderId;
	
	private ShippingAddress shippingAddress;
	
	private billingAddress billingAddress;
	
	//private Cart cart;
	
	private long totalAmount;
	
	private String paymentMethod;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public billingAddress getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(billingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}



	public long getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(long totalAmount) {
		this.totalAmount = totalAmount;
	}

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
