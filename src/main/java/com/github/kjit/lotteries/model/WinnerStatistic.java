package com.github.kjit.lotteries.model;

import java.util.HashMap;
import java.util.Map;

public class WinnerStatistic {

    private EurojackpotResult result;

    private Map<PrizeLevel, Integer> winnerNumbers = new HashMap<>();

    public EurojackpotResult getResult() {
        return result;
    }

    public void setResult(EurojackpotResult result) {
        this.result = result;
    }

    public Map<PrizeLevel, Integer> getWinnerNumbers() {
        return winnerNumbers;
    }

    public void setWinnerNumbers(Map<PrizeLevel, Integer> winnerNumbers) {
        this.winnerNumbers = winnerNumbers;
    }
}
