package com.demo.wallet.paymentdemo;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.demo.wallet.payment.controller.PaymentController;
import com.demo.wallet.payment.exception.CustomException;
import com.demo.wallet.payment.model.Wallet;

@RunWith(MockitoJUnitRunner.class)
public class PaymentControllerTest {

	@InjectMocks
	PaymentController paymentController;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void getFinalNotesCombinationTest_CombinationFound() {

		Wallet paymentRequestPojo = new Wallet();
		List<Integer> notes = new ArrayList<>();
		//notes.add(1);
		notes.add(10);
		//notes.add(1);
		notes.add(5);
		notes.add(1);
		notes.add(20);
		paymentRequestPojo.setAmount(60);
		paymentRequestPojo.setNotes(notes);

		assertNotNull(paymentController.getFinalNotesCombination(paymentRequestPojo));

	}

	@Test
	public void getFinalNotesCombinationTest_NullAmount_ThrowCustomException() {
		Wallet paymentRequestPojo = new Wallet();
		List<Integer> notes = new ArrayList<>();
		notes.add(2);
		paymentRequestPojo.setAmount(-10);
		paymentRequestPojo.setNotes(notes);
		
		thrown.expect(CustomException.class);

		paymentController.getFinalNotesCombination(paymentRequestPojo);


	}
	
	@Test
	public void getFinalNotesCombinationTest_CombinationNotFound() {

		Wallet paymentRequestPojo = new Wallet();
		List<Integer> notes = new ArrayList<>();
		notes.add(1);
		notes.add(10);
		notes.add(5);
		paymentRequestPojo.setAmount(18);
		paymentRequestPojo.setNotes(notes);

		assertNotNull(paymentController.getFinalNotesCombination(paymentRequestPojo));

	}
}
