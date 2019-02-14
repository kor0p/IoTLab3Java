package ua.lviv.iot.security.managers;

import ua.lviv.iot.security.models.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SecuritiesManager {

	private List<Security> securities;

	public SecuritiesManager() {
	}
	
	public SecuritiesManager(List<Security> securities) {
		this.securities = securities;
	}

	public List<Security> sortByPrice(boolean descending) {
		Comparator<Security> comparator = 
			(Security obj1, Security obj2) -> 
			Double.compare((obj1.getPricePerUnit()),(obj2.getPricePerUnit()));
		List<Security> securityList = securities;
		securityList.sort(comparator);
		if (descending) {
			Collections.reverse(securityList);
		}
		return securityList;
	}

	public List<Security> sortByDuration(boolean descending) {
		Comparator<Security> comparator = 
			(Security obj1, Security obj2) ->
			Double.compare((obj1.getDuration()),(obj2.getDuration()));
		List<Security> securityList = securities;
		securityList.sort(comparator);
		if (descending) {
			Collections.reverse(securityList);
		}
		return securityList;
	}

	public List<Security> filterByPrice(double price) {
		List<Security> securityList = securities;
		List<Security> filteredSecurityList = securityList.stream()
				.filter(security -> security.getPricePerUnit() == price)
				.collect(Collectors.toList());
		return filteredSecurityList;
	}

	public List<Security> filterByRiskLevel(RiskLevel riskLevel) {
		List<Security> securityList = securities;
		List<Security> filteredSecurityList = securityList.stream()
				.filter(security -> security.getRiskLevel() == riskLevel)
				.collect(Collectors.toList());
		return filteredSecurityList;
	}

	public List<Security> filterByTrend(Trend trend) {
		List<Security> securityList = securities;
		List<Security> filteredSecurityList = securityList.stream()
				.filter(security -> security.getTrend() == trend)
				.collect(Collectors.toList());
		return filteredSecurityList;
	}

	public List<Security> getSecurities() {
		return securities;
	}

	public void setSecurities(List<Security> securities) {
		this.securities = securities;
	}
	
	public static void main(String[] args) {
		List<Security> securities = new ArrayList<>();
		
		securities.add(new Security(30, "$", RiskLevel.LOW, Trend.UP, 0, "Ukraine", "I"));
		securities.add(new Security(20, "$", RiskLevel.MEDIUM, Trend.DOWN, 0, "Ukraine", "I"));
		securities.add(new Security(10, "$", RiskLevel.HIGH, Trend.UP, 0, "Ukraine", "I"));
		securities.add(new Security(0, "$", RiskLevel.DANGER, Trend.UP, 0, "Ukraine", "I"));
		securities.add(new Security(0, "$", RiskLevel.LOW, Trend.DOWN, 10, "Ukraine", "I"));
		
		SecuritiesManager manager = new SecuritiesManager(securities);
		List<Security> filteredSecurities = manager.filterByPrice(0);
		System.out.println(filteredSecurities);
		
		List<Security> sortedSecurities =
				(new SecuritiesManager(securities)).sortByPrice(false);
		System.out.println(sortedSecurities);
		
		List<Security> sortedFilteredSecurities =
				(new SecuritiesManager(filteredSecurities)).sortByDuration(true);
		System.out.println(sortedFilteredSecurities);
		
	}
}
