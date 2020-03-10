package com.github.kjit.lotteries.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class EurojackpotResult {

    private LocalDate lotteryDate;

    private Set<Integer> winningNumbers = new HashSet<>(5);

    private Set<Integer> euroNumbers = new HashSet<>(2);

    public LocalDate getLotteryDate() {
        return lotteryDate;
    }

    public void setLotteryDate(LocalDate lotteryDate) {
        this.lotteryDate = lotteryDate;
    }

    public Set<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public Set<Integer> getEuroNumbers() {
        return euroNumbers;
    }
}
