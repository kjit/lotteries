package com.github.kjit.lotteries.service;

import com.github.kjit.lotteries.model.EurojackpotResult;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class EurojackpotGeneratorTest {
    Logger LOG =  LoggerFactory.getLogger(EurojackpotGeneratorTest.class);

    @Test
    void shouldGenerateRandomNumbers() {

        EurojackpotResult result = new EurojackpotGenerator().generateResultByStreamFor(LocalDate.now());

        LOG.info("Numbers: " + result.getEuroNumbers());
    }

}