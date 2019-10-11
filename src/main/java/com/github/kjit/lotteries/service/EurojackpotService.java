package com.github.kjit.lotteries.service;

import com.github.kjit.lotteries.dao.EurojackpotDao;
import com.github.kjit.lotteries.model.EurojackpotResult;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EurojackpotService {

    private EurojackpotDao dao;

    public EurojackpotService(@Autowired EurojackpotDao dao) {
        this.dao = dao;
    }

    public Optional<EurojackpotResult> findByDate(LocalDate lotteryDate) {
        return dao.getResults().stream()
                .filter(ejpR -> ejpR.getLotteryDate().isEqual(lotteryDate)).findFirst();
    }

    public List<EurojackpotResult> findByDateRange(LocalDate startDate, LocalDate endDate) {
        return dao.getResults().stream()
                .filter(ejpR -> isBetween(ejpR.getLotteryDate(), startDate, endDate))
                .collect(Collectors.toList());
    }

    public List<EurojackpotResult> getLatestResults() {
        LocalDate boundary = LocalDate.now().minusDays(32);
        return dao.getResults().stream()
                .filter(ejpR -> ejpR.getLotteryDate().isAfter(boundary))
                .collect(Collectors.toList());
    }

    // TODO Item 42
    List<EurojackpotResult> sortByDate(List<EurojackpotResult> list) {
        Collections.sort(list, Comparator.comparing(EurojackpotResult::getLotteryDate));
        return list;
    }


    private boolean isBetween(LocalDate ld, LocalDate startDate, LocalDate endDate) {
        return ld.isEqual(startDate) || ld.isEqual(endDate) ||
                (ld.isAfter(startDate) && ld.isBefore(endDate));

    }


}
