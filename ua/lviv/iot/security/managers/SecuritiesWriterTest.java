package ua.lviv.iot.security.managers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ua.lviv.iot.security.models.Debt;
import ua.lviv.iot.security.models.Derivative;
import ua.lviv.iot.security.models.Equity;
import ua.lviv.iot.security.models.RiskLevel;
import ua.lviv.iot.security.models.Security;
import ua.lviv.iot.security.models.Trend;

class SecuritiesWriterTest {

  private List<Security> securities;

  public void setUp() {
    securities = new ArrayList<>();
  }
  
  @BeforeEach
  public void beforeEach() {
    securities = new ArrayList<>();
    securities.add(new Security(300, "$", RiskLevel.LOW, Trend.UP, 0, "Ukraine", "I"));
    securities.add(new Equity(2000, "₴", RiskLevel.MEDIUM, Trend.DOWN, 100,
        "Russia", "I", "Roshen", 0.5));
    securities.add(new Debt(10, "€", RiskLevel.HIGH, Trend.UP, 3000, "Belarus",
        "I", null, new Security()));
    securities.add(new Derivative(0, "$", RiskLevel.DANGER, Trend.UP, 0, "Moldova", "I", "house"));
    securities.add(new Security(20, "$", RiskLevel.LOW, Trend.DOWN, 10, "Ukraine", "I"));
  }
  
  @Test
  public void testWriteToFile() throws FileNotFoundException, IOException {
    SecuritiesWriter.writeToFile(securities);
    File myFile = new File("out.csv");
    try (FileInputStream fis = new FileInputStream(myFile);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader bufReader = new BufferedReader(isr);) {
      String line = null;
      String lines = "";
      while ((line = bufReader.readLine()) != null) {
        lines += line + "\n";
      }
      lines = lines.substring(0, lines.length() - 1);
      System.out.println(lines);
      Assertions.assertEquals(
          "pricePerUnit,currency,riskLevel,trend,duration,emitent,owner\n"
          + "300.0,$,LOW,UP,0.0,Ukraine,I\n"
          + "pricePerUnit,currency,riskLevel,trend,duration,emitent,owner,"
          + "company,percentOfCompany\n"
          + "2000.0,₴,MEDIUM,DOWN,100.0,Russia,I,Roshen,0.5\n"
          + "pricePerUnit,currency,riskLevel,trend,duration,emitent,owner,asset,secutity\n"
          + "10.0,€,HIGH,UP,3000.0,Belarus,I,null,Security: \n"
          + "[\n"
          + "  pricePerUnit,currency,riskLevel,trend,duration,emitent,owner\n"
          + "  0.0,null,null,null,0.0,null,null\n"
          + "]\n"
          + "\n"
          + "pricePerUnit,currency,riskLevel,trend,duration,emitent,owner,asset\n"
          + "0.0,$,DANGER,UP,0.0,Moldova,I,house\n"
          + "pricePerUnit,currency,riskLevel,trend,duration,emitent,owner\n"
          + "20.0,$,LOW,DOWN,10.0,Ukraine,I",lines);
    } finally {
      System.out.println();
    }
  }

}
