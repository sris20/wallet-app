package com.demo.wallet.payment.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.wallet.payment.exception.CustomException;
import com.demo.wallet.payment.model.ResponsePojo;
import com.demo.wallet.payment.model.Wallet;


@RestController	
//@Log4j2
public class PaymentController {

	public static final Logger LOG = LogManager.getLogger(PaymentController.class);

	@GetMapping(value = "/notes")
	public ResponsePojo getFinalNotesCombination(@RequestBody Wallet wallet) {
		
		int amount = wallet.getAmount();
		
		if(amount<0) {
			throw new CustomException("Amount can not be less than 0 : "+amount+"  ");
		}
		List<Integer> notes = wallet.getNotes();
		ResponsePojo response = new ResponsePojo();

		if (notes != null && !notes.isEmpty() && amount != 0) {

			// Populate denomination-count map
			Map<Integer, Integer> notesCountMap = new HashMap<>();

			notes.stream().distinct().collect(Collectors.toList()).forEach(note -> {
				int noteCount = (int) notes.stream().filter(n -> n.equals(note)).count();
				notes.removeIf(n -> n.equals(note));
				notesCountMap.put(note, noteCount);
			});

			LOG.info(" Sris final notes:   " + notes);
			LOG.info(" Sris notesCountMap: " + notesCountMap);

			List<Integer> keySetList = notesCountMap.keySet().stream().sorted(Comparator.reverseOrder())
					.collect(Collectors.toList());
			LOG.info(" Sris keySet:  " + keySetList);
			Map<Integer, Integer> resultMap = new HashMap<>();

			amount = populateResultMap(amount, notesCountMap, keySetList, resultMap);
			if (amount <= 0) {
				// populate response list
				List<Integer> resultNoteList = new ArrayList<>();
				Set<Integer> resultKeySets = resultMap.keySet();
				for (Integer ks : resultKeySets) {
					for (int i = 0; i < resultMap.get(ks); i++) {
						resultNoteList.add(ks);
					}
				}
				response.setResultNoteList(resultNoteList);
			} else {
				response.setResultNoteList(null);
			}
			return response;
		}
		return response;

	}

	private int populateResultMap(int amount, Map<Integer, Integer> notesCountMap, List<Integer> keySetList,
			Map<Integer, Integer> resultMap) {

		// Den : Count..
		for (Integer denomination : keySetList) {

			if (amount != 0) {

				int remainder = amount % denomination;
				int quot = amount / denomination;
				int noteCountPermitted = notesCountMap.get(denomination);

				if (remainder == 0) {
					addValueInResultMap(resultMap, quot, denomination, noteCountPermitted);
					amount = (quot - noteCountPermitted) * denomination;
				} else if (remainder != amount) {
					addValueInResultMap(resultMap, quot, denomination, noteCountPermitted);
					if (quot > noteCountPermitted) {
						amount = ((quot - noteCountPermitted) * denomination) + remainder;
					} else {
						amount = remainder;
					}
				}
			}

		}
		return amount;
	}

	private void addValueInResultMap(Map<Integer, Integer> resultMap, int quot, Integer denomination,
			int noteCountPermitted) {
		if (quot > noteCountPermitted)
			resultMap.put(denomination, noteCountPermitted);
		else
			resultMap.put(denomination, quot);
	}

}
