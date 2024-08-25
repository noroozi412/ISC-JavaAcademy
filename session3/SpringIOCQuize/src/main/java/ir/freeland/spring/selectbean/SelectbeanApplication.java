package ir.freeland.spring.selectbean;

import ir.freeland.spring.selectbean.service.BankiranServices;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SelectbeanApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SelectbeanApplication.class);

		BankiranServices bankiranServices = context.getBean(BankiranServices.class);

		bankiranServices.accountTransaction("136-800-384123");
	}
}