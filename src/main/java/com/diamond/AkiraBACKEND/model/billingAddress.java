package com.diamond.AkiraBACKEND.model;



import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;

@Entity
@Component
public class billingAddress implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	private String billingAddressId;
	
	@NotBlank(message="specific main address")
	private String line1;
	
	@NotBlank
	private String line2;
	
	@NotBlank
	private String state;
	
	@NotBlank
	private String city;
	
	@NotBlank
	private String country;
	
	@NotBlank
	private String zipcode;

	public String getBillingAddressId() {
		return billingAddressId;
	}

	public void setBillingAddressId(String billingAddressId) {
		this.billingAddressId = billingAddressId;
	}

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZincode() {
		return zipcode;
	}

	public void setZincode(String zincode) {
		this.zipcode = zincode;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "billingAddress [billingAddressId=" + billingAddressId + ", line1=" + line1 + ", line2=" + line2
				+ ", state=" + state + ", city=" + city + ", country=" + country + ", zipcode=" + zipcode + "]";
	}


	
}
