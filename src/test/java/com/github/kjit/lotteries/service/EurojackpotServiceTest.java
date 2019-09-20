package com.github.kjit.lotteries.service;

import com.github.kjit.lotteries.dao.EurojackpotDao;
import com.github.kjit.lotteries.model.EurojackpotResult;
import com.github.kjit.lotteries.model.EurojackpotResultAssert;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.assertj.core.api.Assertions.assertThat;

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
        LocalDate currentDate = LocalDate.now();
        r.setLotteryDate(currentDate);
        r.getEuroNumbers()[0] = 2;
        r.getEuroNumbers()[1] = 4;
        resultsValues.add(r);
        Mockito.when(dao.getResults()).thenReturn(resultsValues);

        List<EurojackpotResult> serviceResult = service.getLatestResults();

        assertThat(serviceResult).hasSize(1);
        assertThat(serviceResult).containsExactly(r);

        assertThat(serviceResult).anySatisfy(results -> {
            assertThat(results.getLotteryDate()).isEqualTo(currentDate);
            assertThat(results.getEuroNumbers()[0]).isEqualTo(2);
        });

        assertThat(serviceResult).extracting(EurojackpotResult::getEuroNumbers)
                .containsExactly(new int[]{2, 4});

        assertThat(serviceResult.get(0)).satisfies(results ->
                assertThat(results.getEuroNumbers())
                        .as("Euro Numbers should be ")
                        .contains(2, 4));

        EurojackpotResultAssert.assertThat(serviceResult.get(0))
                .hasLotteryDate(LocalDate.now())
                .hasEuroNumbers(2, 4);
    }
}
