package com.github.kjit.lotteries.service;

import com.github.kjit.lotteries.model.EurojackpotResult;
import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;
import org.springframework.stereotype.Service;

@Service
public class EurojackpotGenerator {

    // TODO Item 45

    EurojackpotResult generateResultFor(LocalDate lotteryDay) {
        EurojackpotResult result = new EurojackpotResult();
        ThreadLocalRandom random = ThreadLocalRandom.current();
        for (int i = 0; i < 5; i++) {
            int next = random.nextInt(50);
            result.addWinningNumber(next);
        }
        for (int i = 0; i < 2; i++) {
            int next = random.nextInt(10);
            result.addEuroNumber(next);
        }
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
