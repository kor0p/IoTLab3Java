package ua.lviv.iot.security.managers;

import java.util.ArrayList;
import java.util.List;

import ua.lviv.iot.security.models.Debt;
import ua.lviv.iot.security.models.Derivative;
import ua.lviv.iot.security.models.Equity;
import ua.lviv.iot.security.models.RiskLevel;
import ua.lviv.iot.security.models.Security;
import ua.lviv.iot.security.models.Trend;

public class Main {
	public static void main(String[] args) {
		final List<Security> securities = new ArrayList<>();

		securities.add(new Security(30, "$", RiskLevel.LOW, Trend.UP, 0, "Ukraine", "I"));
		securities.add(new Equity(20, "$", RiskLevel.MEDIUM, Trend.DOWN, 0, "Russia", "I", "Roshen", 0.5));
		securities.add(new Debt(10, "$", RiskLevel.HIGH, Trend.UP, 0, "Belarus", "I", "", new Security()));
		securities.add(new Derivative(0, "$", RiskLevel.DANGER, Trend.UP, 0, "Moldova", "I", "house"));
		securities.add(new Security(0, "$", RiskLevel.LOW, Trend.DOWN, 10, "Ukraine", "I"));

		final SecuritiesManagerImpl manager = new SecuritiesManagerImpl(securities);
		final List<Security> filteredList = manager.filterByPriceEquals(0);
		System.out.println(filteredList);

		SecuritiesManagerImpl.sortByPriceAscending(securities);
		System.out.println(securities);

		SecuritiesManagerImpl.sortByDurationDescending(filteredList);
		System.out.println(filteredList);

	}
}
