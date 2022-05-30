package com.demo.wallet.payment.model;

import java.util.List;

public class Wallet {

	private List<Integer> notes;
	
	private int amount;


	public List<Integer> getNotes() {
		return notes;
	}

	public void setNotes(List<Integer> notes) {
		this.notes = notes;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "PaymentRequestPojo [notes=" + notes + ", amount=" + amount + "]";
	}
	
	
}
