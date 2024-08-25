package ir.freeland.spring.selectbean.service;

import org.springframework.stereotype.Component;

import java.io.File;
@Component
public class EDBBankiranServices implements BankiranServices {


	@Override
	public File accountTransaction(String accountNumber) {
		return new File("account-report");
	}
}