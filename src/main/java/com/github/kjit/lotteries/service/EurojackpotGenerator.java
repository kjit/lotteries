package com.github.kjit.lotteries.service;

import com.github.kjit.lotteries.model.EurojackpotResult;
import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;
import org.springframework.stereotype.Service;

@Service
public class EurojackpotGenerator {

    EurojackpotResult generateResultFor(LocalDate lotteryDay) {
        EurojackpotResult result = new EurojackpotResult();
        ThreadLocalRandom random = ThreadLocalRandom.current();
        do {
            int next = 1 + random.nextInt(50);
            result.getWinningNumbers().add(next);
        } while (result.getWinningNumbers().size() < 5);

        do {
            int next = 1 + random.nextInt(10);
            result.getEuroNumbers().add(next);
        } while (result.getEuroNumbers().size() < 2);

        result.setLotteryDate(lotteryDay);
        return result;
    }

    EurojackpotResult generateResultByStreamFor(LocalDate lotteryDay) {
        EurojackpotResult result = new EurojackpotResult();
        ThreadLocalRandom random = ThreadLocalRandom.current();
        random.ints(5, 0, 50)
                .forEach(result::addWinningNumber);
        random.ints(2, 0, 10)
                .forEach(result::addEuroNumber);
        result.setLotteryDate(lotteryDay);
        return result;
    }
}
