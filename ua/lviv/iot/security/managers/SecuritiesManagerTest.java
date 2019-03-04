package ua.lviv.iot.security.managers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ua.lviv.iot.security.models.Debt;
import ua.lviv.iot.security.models.Derivative;
import ua.lviv.iot.security.models.Equity;
import ua.lviv.iot.security.models.RiskLevel;
import ua.lviv.iot.security.models.Security;
import ua.lviv.iot.security.models.Trend;

class SecuritiesManagerTest {

    private List<Security> securities;

    private SecuritiesManagerImpl securitiesManager;

    public void setUp() {
    	securities = new ArrayList<>();
        SecuritiesManagerImpl securitiesManager = new SecuritiesManagerImpl();
    }

    @BeforeEach
    public void beforeEach() {
        securities = new ArrayList<>();
        securities.add(new Security(300, "$", RiskLevel.LOW, Trend.UP, 0, "Ukraine", "I"));
        securities.add(new Equity(2000, "₴", RiskLevel.MEDIUM, Trend.DOWN, 0, "Russia", "I", "Roshen", 0.5));
        securities.add(new Debt(10, "€", RiskLevel.HIGH, Trend.UP, 0, "Belarus", "I", "", new Security()));
        securities.add(new Derivative(0, "$", RiskLevel.DANGER, Trend.UP, 0, "Moldova", "I", "house"));
        securities.add(new Security(20, "$", RiskLevel.LOW, Trend.DOWN, 10, "Ukraine", "I"));
        securitiesManager = new SecuritiesManagerImpl(securities);
    }

    @Test
    void testFilterByPriceEquals() {
        System.out.println(securitiesManager.filterByPriceEquals(0.0));
        System.out.println(securitiesManager.filterByPriceEquals(10.0));
        System.out.println(securitiesManager.filterByPriceEquals(20.0));
        System.out.println(securitiesManager.filterByPriceEquals(300.0));
        System.out.println(securitiesManager.filterByPriceEquals(2000.0));
    }
    
    @Test
    void testFilterByPriceBiggerThan() {
        System.out.println(securitiesManager.filterByPriceBiggerThan(0.0));
        System.out.println(securitiesManager.filterByPriceBiggerThan(10.0));
        System.out.println(securitiesManager.filterByPriceBiggerThan(100.0));
        System.out.println(securitiesManager.filterByPriceBiggerThan(1000.0));
    }
    
    @Test
    void testFilterByPriceLowerThan() {
        System.out.println(securitiesManager.filterByPriceLowerThan(10000.0));
        System.out.println(securitiesManager.filterByPriceLowerThan(1000.0));
        System.out.println(securitiesManager.filterByPriceLowerThan(100.0));
        System.out.println(securitiesManager.filterByPriceLowerThan(10.0));
    }
    
    @Test
    void testFilterByTrendEquals() {
        System.out.println(securitiesManager.filterByTrend(Trend.DOWN));
        System.out.println(securitiesManager.filterByTrend(Trend.UP));
    }
    
    @Test
    void testFilterByRiskLevelEquals() {
        System.out.println(securitiesManager.filterByRiskLevelEquals(RiskLevel.DANGER));
        System.out.println(securitiesManager.filterByRiskLevelEquals(RiskLevel.HIGH));
        System.out.println(securitiesManager.filterByRiskLevelEquals(RiskLevel.MEDIUM));
        System.out.println(securitiesManager.filterByRiskLevelEquals(RiskLevel.LOW));
    }
    
    @Test
    void testFilterByRiskLevelBiggerThan() {
        System.out.println(securitiesManager.filterByRiskLevelBiggerThan(RiskLevel.HIGH));
        System.out.println(securitiesManager.filterByRiskLevelBiggerThan(RiskLevel.MEDIUM));
        System.out.println(securitiesManager.filterByRiskLevelBiggerThan(RiskLevel.LOW));
    }
    
    @Test
    void testFilterByRiskLevelLowerThan() {
        System.out.println(securitiesManager.filterByRiskLevelLowerThan(RiskLevel.DANGER));
        System.out.println(securitiesManager.filterByRiskLevelLowerThan(RiskLevel.HIGH));
        System.out.println(securitiesManager.filterByRiskLevelLowerThan(RiskLevel.MEDIUM));
    }
    
    @Test
    void testSortPriceAscending() {
        SecuritiesManagerImpl.sortByPriceAscending(securities);
        System.out.println(securities);
    }
    
    @Test
    void testSortPriceDescending() {
        SecuritiesManagerImpl.sortByPriceDescending(securities);
        System.out.println(securities);
    }
    
    @Test
    void testSortDurationAscending() {
        SecuritiesManagerImpl.sortByDurationAscending(securities);
        System.out.println(securities);
    }
    
    @Test
    void testSortDurationDescending() {
        SecuritiesManagerImpl.sortByDurationDescending(securities);
        System.out.println(securities);
    }
}
