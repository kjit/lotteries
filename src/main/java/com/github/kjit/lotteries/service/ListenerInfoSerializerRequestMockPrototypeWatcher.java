package com.github.kjit.lotteries.service;

import java.util.List;
import java.util.stream.Collectors;

public class ListenerInfoSerializerRequestMockPrototypeWatcher {

    static Integer addSomethingAndMore(int x) {
        return x + 2 * x;
    }

    // TODO Item 43
    List<Integer> calculate(List<Integer> list1, List<Integer> list2) {
        return list1.stream()
                .map(ListenerInfoSerializerRequestMockPrototypeWatcher::addSomethingAndMore)
                .collect(Collectors.toList());
    }
}
