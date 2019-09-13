package com.github.kjit.lotteries.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
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
	
	@Test
	public void shouldFindByDate() {
		List<EurojackpotResult> resultsValues = new ArrayList<>();
		EurojackpotResult r = new EurojackpotResult();
		r.setLotteryDate(LocalDate.now());
		resultsValues.add(r);
		Mockito.when(dao.getResults()).thenReturn(resultsValues);
		
		List<EurojackpotResult> serviceResult = service.getLatestResults();
		
		Assertions.assertThat(serviceResult).hasSize(1);
	}
	

}
