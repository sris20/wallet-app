package com.demo.basic;

public class Address {

	private String addressLine1;

	private String addressLine2;
	
	private int zipCode;
	
	private boolean isPermanentAddress=false;
	
	

	public boolean isPermanentAddress() {
		return isPermanentAddress;
	}

	public void setPermanentAddress(boolean isPermanentAddress) {
		this.isPermanentAddress = isPermanentAddress;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	
	
}
