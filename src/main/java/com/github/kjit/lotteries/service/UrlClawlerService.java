package com.github.kjit.lotteries.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import org.springframework.stereotype.Service;

@Service
public class UrlClawlerService {

    // TODO Item 59
    public void readAndPrintURLContent(String url) {

    }



























    public void printUrlContentUsingJava9(String url) throws IOException {
        try (InputStream in = new URL(url).openStream()) {
            in.transferTo(System.out);
        }
    }
}
