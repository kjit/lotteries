package com.github.kjit.lotteries.model;

import java.time.LocalDate;

public class EurojackpotResult {
	
	private LocalDate lotteryDate;
	
	private int[] winningNumbers = new int[5];
	
	private int[] euroNumbers = new int[2];

	public LocalDate getLotteryDate() {
		return lotteryDate;
	}

	public void setLotteryDate(LocalDate lotteryDate) {
		this.lotteryDate = lotteryDate;
	}

	public int[] getWinningNumbers() {
		return winningNumbers;
	}
	
	public int[] getEuroNumbers() {
		return euroNumbers;
	}

	
}
