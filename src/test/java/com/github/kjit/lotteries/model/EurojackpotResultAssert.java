package com.github.kjit.lotteries.model;

import java.time.LocalDate;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

public class EurojackpotResultAssert extends AbstractAssert<EurojackpotResultAssert, EurojackpotResult> {

    public static EurojackpotResultAssert assertThat(EurojackpotResult eurojackpotResult) {
        return new EurojackpotResultAssert(eurojackpotResult);
    }

    private EurojackpotResultAssert(EurojackpotResult eurojackpotResult) {
        super(eurojackpotResult, EurojackpotResultAssert.class);
    }

    public EurojackpotResultAssert hasLotteryDate(LocalDate localDate) {
        isNotNull();

        if (!actual.getLotteryDate().isEqual(localDate)) {
            failWithMessage("Invalid date provided - %s , expected %s", actual.getLotteryDate(), localDate);
        }
        return this;
    }

    public EurojackpotResultAssert hasEuroNumbers(int x1, int x2) {
        isNotNull();

        Assertions.assertThat(actual.getEuroNumbers()).containsExactly(x1, x2);
        return this;
    }
}