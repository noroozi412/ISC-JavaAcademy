package ir.freeland.spring.usebean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InternetbankServices {

  @Autowired  // Inject CardServices and DatabaseManagment instances
  private CardServices cardServices;

  @Autowired
  private DatabaseManagment databaseManagment;

  public void doCardToCard(String sourceCard, String destinationCard) {
    String result = cardServices.cardToCard(sourceCard, destinationCard);
    databaseManagment.save(result);
  }
}