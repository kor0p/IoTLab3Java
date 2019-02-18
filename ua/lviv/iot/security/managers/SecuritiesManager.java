package ua.lviv.iot.security.managers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ua.lviv.iot.security.models.Debt;
import ua.lviv.iot.security.models.Derivative;
import ua.lviv.iot.security.models.Equity;
import ua.lviv.iot.security.models.RiskLevel;
import ua.lviv.iot.security.models.Security;
import ua.lviv.iot.security.models.Trend;

public class SecuritiesManager {

  private List<Security> securities;

  public SecuritiesManager() {
	  super();
  }
  
  public SecuritiesManager(final List<Security> securities) {
    this.securities = securities;
  }

  public List<Security> sortByPrice(final boolean descending) {
    final Comparator<Security> comparator = 
        (obj1,obj2) -> Double.compare(obj1.getPricePerUnit(),obj2.getPricePerUnit());
    final List<Security> securityList = securities;
    securityList.sort(comparator);
    if (descending) {
      Collections.reverse(securityList);
    }
    return securityList;
  }

  public List<Security> sortByDuration(boolean descending) {
    final Comparator<Security> comparator = 
        (obj1, obj2) -> Double.compare(obj1.getDuration(),obj2.getDuration());
    final List<Security> securityList = securities;
    securityList.sort(comparator);
    if (descending) {
      Collections.reverse(securityList);
    }
    return securityList;
  }

  public List<Security> filterByPrice(final double price) {
    Stream<Security> securityList = securities.stream();
    securityList = securityList.filter(security -> security.getPricePerUnit() == price);
    return securityList.collect(Collectors.toList());
  }

  public List<Security> filterByRiskLevel(final RiskLevel riskLevel) {
    Stream<Security> securityList = securities.stream();
    securityList = securityList.filter(security -> security.getRiskLevel() == riskLevel);
    return securityList.collect(Collectors.toList());
  }

  public List<Security> filterByTrend(final Trend trend) {
    Stream<Security> securityList = securities.stream();
    securityList = securityList.filter(security -> security.getTrend() == trend);
    return securityList.collect(Collectors.toList());
  }

  public List<Security> getSecurities() {
    return securities;
  }

  public void setSecurities(final List<Security> securities) {
    this.securities = securities;
  }
  
  public static void main(String[] args) {
    final List<Security> securities = new ArrayList<>();
    
    securities.add(new Security(30, "$", RiskLevel.LOW, Trend.UP, 0, "Ukraine", "I"));
    securities.add(new Equity(
        20, "$", RiskLevel.MEDIUM, Trend.DOWN, 0, "Russia", "I", "Roshen", 0.5));
    securities.add(new Debt(
        10, "$", RiskLevel.HIGH, Trend.UP, 0, "Belarus", "I", "", new Security()));
    securities.add(new Derivative(0, "$", RiskLevel.DANGER, Trend.UP, 0, "Moldova", "I", "house"));
    securities.add(new Security(0, "$", RiskLevel.LOW, Trend.DOWN, 10, "Ukraine", "I"));
    
    final SecuritiesManager manager = new SecuritiesManager(securities);
    final List<Security> filteredList = manager.filterByPrice(0);
    System.out.println(filteredList);
    
    final List<Security> sortedList =
        new SecuritiesManager(securities).sortByPrice(false);
    System.out.println(sortedList);
    
    final List<Security> sortedFilteredList =
        new SecuritiesManager(filteredList).sortByDuration(true);
    System.out.println(sortedFilteredList);
    
  }
}
