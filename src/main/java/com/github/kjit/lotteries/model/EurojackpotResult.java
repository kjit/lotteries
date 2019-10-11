package com.github.kjit.lotteries.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class EurojackpotResult {

    private LocalDate lotteryDate;

    private List<Integer> winningNumbers = new ArrayList<>(5);
    private List<Integer> euroNumbers = new ArrayList<>(5);

    public LocalDate getLotteryDate() {
        return lotteryDate;
    }

    public void setLotteryDate(LocalDate lotteryDate) {
        this.lotteryDate = lotteryDate;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public void addWinningNumber(Integer nextNumber) {
        if (winningNumbers.size() > 5) {
            throw new IllegalStateException("Cannot add more than 5 winning numbers");
        }
        winningNumbers.add(nextNumber);
    }

    public List<Integer> getEuroNumbers() {
        return euroNumbers;
    }

    public void addEuroNumber(Integer nextNumber) {
        if (euroNumbers.size() > 2) {
            throw new IllegalStateException("Cannot add more than 2 winning numbers");
        }
        euroNumbers.add(nextNumber);
    }

}
