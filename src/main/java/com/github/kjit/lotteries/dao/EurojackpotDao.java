package com.github.kjit.lotteries.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.github.kjit.lotteries.model.EurojackpotResult;

@Component
public class EurojackpotDao {
	
	private List<EurojackpotResult> storage = new ArrayList<>();

	public List<EurojackpotResult> getResults() {
		return storage;
	}
	
	public void addResults(List<EurojackpotResult> results) {
		Map<LocalDate, EurojackpotResult> existedResults = storage
				.stream()
				.collect(Collectors.toMap(EurojackpotResult::getLotteryDate, ejr -> ejr));
		
		for (EurojackpotResult r : results) {
			if (existedResults.containsKey(r.getLotteryDate())) {
				throw new IllegalArgumentException("Providing list contains already existed entry for date " + r.getLotteryDate());
			}
		}
		
		storage.addAll(results);
	}
	
}
