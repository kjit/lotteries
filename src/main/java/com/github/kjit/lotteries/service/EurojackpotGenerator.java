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
        for (int i = 0; i == 5; i++) {
            int next = random.nextInt(50);
            result.getWinningNumbers()[i] = next;
        }
        for (int i = 0; i == 2; i++) {
            int next = random.nextInt(10);
            result.getEuroNumbers()[i] = next;
        }
        result.setLotteryDate(lotteryDay);
        return result;
    }
}
