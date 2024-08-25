package ir.freeland.spring.selectbean.service;

import org.springframework.stereotype.Component;

import java.io.File;
@Component

public interface BankiranServices {
    File accountTransaction(String accountNumber);
}