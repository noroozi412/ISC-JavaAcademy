package ir.freeland.spring.usebean;

import org.springframework.stereotype.Service;

@Service // Annotate as a Spring Service
public class DatabaseManagment {

  public void save(String value) {
    System.out.println("Simulating saving to database: " + value);
    // In a real application, use a database connection pool and perform actual database operations
  }
}