package com.github.kjit.lotteries.service;

import java.io.IOException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UrlClawlerServiceTest {

    @Test
    void shouldPrintUrl() throws IOException {

        new UrlClawlerService().printUrlContentUsingJava9("https://www.wp.pl");
    }

}