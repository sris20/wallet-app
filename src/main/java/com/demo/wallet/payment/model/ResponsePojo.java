package com.demo.wallet.payment.model;

import java.util.List;


public class ResponsePojo {

	private List<Integer> resultNoteList;

	public List<Integer> getResultNoteList() {
		return resultNoteList;
	}

	public void setResultNoteList(List<Integer> resultNoteList) {
		this.resultNoteList = resultNoteList;
	}

	@Override
	public String toString() {
		return "PaymentResponsePojo [resultNoteList=" + resultNoteList + "]";
	}
	
	
}
