package ua.lviv.iot.security.managers;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import ua.lviv.iot.security.models.RiskLevel;
import ua.lviv.iot.security.models.Security;
import ua.lviv.iot.security.models.Trend;

public class SecuritiesManagerImpl implements SecuritiesManager {

	private List<Security> securities;

	public SecuritiesManagerImpl() {
		super();
	}

	public SecuritiesManagerImpl(final List<Security> securities) {
		this.securities = securities;
	}

	@Override
	public void addSecurity(Security security) {

	}

	interface SearchableCriteria<T> {
		boolean matchCriteria(T criteria);
	}

	public List<Security> filterSecuritiesByCriteria(SearchableCriteria<Security> criteria) {

		return securities.stream().filter(security -> criteria.matchCriteria(security)).collect(Collectors.toList());
	}

	public List<Security> filterByPriceBiggerThan(final double price) {
		return filterSecuritiesByCriteria(criteria -> criteria.getPricePerUnit() > price);
	}

	public List<Security> filterByPriceLowerThan(final double price) {
		return filterSecuritiesByCriteria(criteria -> criteria.getPricePerUnit() < price);
	}

	public List<Security> filterByPriceEquals(final double price) {
		return filterSecuritiesByCriteria(criteria -> criteria.getPricePerUnit() == price);
	}

	public List<Security> filterByRiskLevelBiggerThan(final RiskLevel riskLevel) {
		return filterSecuritiesByCriteria(criteria -> criteria.getRiskLevel().compareTo(riskLevel) > 0);
	}

	public List<Security> filterByRiskLevelLowerThan(final RiskLevel riskLevel) {
		return filterSecuritiesByCriteria(criteria -> criteria.getRiskLevel().compareTo(riskLevel) < 0);
	}

	public List<Security> filterByRiskLevelEquals(final RiskLevel riskLevel) {
		return filterSecuritiesByCriteria(criteria -> criteria.getRiskLevel().compareTo(riskLevel) == 0);
	}
	
	public List<Security> filterByTrend(final Trend trend) {
		return filterSecuritiesByCriteria(criteria -> criteria.getTrend().compareTo(trend) == 0);
	}

	public static void sortByPriceAscending(List<Security> securities) {
		Collections.sort(securities, Comparator.comparing(Security::getPricePerUnit));
	}

	public static void sortByPriceDescending(List<Security> securities) {
		Collections.sort(securities, Comparator.comparing(Security::getPricePerUnit).reversed());
	}

	public static void sortByDurationAscending(List<Security> securities) {
		Collections.sort(securities, Comparator.comparing(Security::getDuration));
	}

	public static void sortByDurationDescending(List<Security> securities) {
		Collections.sort(securities, Comparator.comparing(Security::getDuration).reversed());
	}

	public List<Security> getSecurities() {
		return securities;
	}

	public void setSecurities(final List<Security> securities) {
		this.securities = securities;
	}
}
