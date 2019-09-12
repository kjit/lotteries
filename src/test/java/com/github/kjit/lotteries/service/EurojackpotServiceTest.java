package com.github.kjit.lotteries.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.github.kjit.lotteries.dao.EurojackpotDao;
import com.github.kjit.lotteries.model.EurojackpotResult;


@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.STRICT_STUBS)
public class EurojackpotServiceTest {

	@InjectMocks
	private EurojackpotService service;
	
	@Mock
	private EurojackpotDao dao;
	
	public void shouldFindByDate() {
		List<EurojackpotResult> resultsValues = new ArrayList<>();
		Mockito.when(dao.getResults()).thenReturn(resultsValues);
		
		List<EurojackpotResult> serviceResult = service.getLatestResults();
		
		Assertions.assertThat(serviceResult).hasSize(0);
	}
	
	public List<EurojackpotResult> findByDateRange(LocalDate startDate, LocalDate endDate) {
		return dao.getResults().stream()
				.filter(ejpR -> isBetween(ejpR.getLotteryDate(), startDate, endDate))
				.collect(Collectors.toList());
	}
	
	private boolean isBetween(LocalDate ld, LocalDate startDate, LocalDate endDate) {
		return ld.isEqual(startDate) || ld.isEqual(endDate) || 
				(ld.isAfter(startDate) && ld.isBefore(endDate));
	}

	public List<EurojackpotResult> getLatestResults() {
		LocalDate boundary = LocalDate.now().minusDays(32); 
		return dao.getResults().stream()
				.filter(ejpR -> ejpR.getLotteryDate().isAfter(boundary))
				.collect(Collectors.toList());
	}
}
