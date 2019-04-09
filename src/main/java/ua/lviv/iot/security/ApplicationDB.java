package ua.lviv.iot.security;

import java.sql.SQLException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ua.lviv.iot.security.models.Equity;
import ua.lviv.iot.security.models.RiskLevel;
import ua.lviv.iot.security.models.Trend;

@SpringBootApplication
public class ApplicationDB {

  public static void main(String... args) throws SQLException {
    SpringApplication.run(ApplicationDB.class, args);
  }

  @Bean
  public CommandLineRunner demo(EquityRepository repository) {
    return (args) -> {
      repository.save(new Equity(300, "€", RiskLevel.LOW, Trend.UP, 0, "Ukraine", "I", "GazProm", 0.5111));
      repository.save(new Equity(20, "$", RiskLevel.LOW, Trend.DOWN, 910, "Ukraine", "You", "NBU", 1));
      repository.save(new Equity(2000, "₴", RiskLevel.MEDIUM, Trend.DOWN, 100, "Russia", "I", "Roshen", 0.5));

      repository.findAll().forEach(System.out::println);
    };
  }
}