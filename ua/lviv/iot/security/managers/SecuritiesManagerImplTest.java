package ua.lviv.iot.security.managers;

import static org.junit.jupiter.api.Assertions.*;

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

class SecuritiesManagerImplTest {

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
        securities.add(new Equity(2000, "₴", RiskLevel.MEDIUM, Trend.DOWN, 100, "Russia", "I", "Roshen", 0.5));
        securities.add(new Debt(10, "€", RiskLevel.HIGH, Trend.UP, 3000, "Belarus", "I", "", new Security()));
        securities.add(new Derivative(0, "$", RiskLevel.DANGER, Trend.UP, 0, "Moldova", "I", "house"));
        securities.add(new Security(20, "$", RiskLevel.LOW, Trend.DOWN, 10, "Ukraine", "I"));
        securitiesManager = new SecuritiesManagerImpl(securities);
    }

    @Test
    void testFilterByPriceEquals() {
    	Assertions.assertEquals(1, securitiesManager.filterByPriceEquals(0.0).size());
    	Assertions.assertEquals(1, securitiesManager.filterByPriceEquals(10.0).size());
    	Assertions.assertEquals(1, securitiesManager.filterByPriceEquals(20.0).size());
    	Assertions.assertEquals(1, securitiesManager.filterByPriceEquals(300.0).size());
    	Assertions.assertEquals(1, securitiesManager.filterByPriceEquals(2000.0).size());
    }
    
    @Test
    void testFilterByPriceBiggerThan() {
    	Assertions.assertEquals(4, securitiesManager.filterByPriceBiggerThan(0.0).size());
    	Assertions.assertEquals(3, securitiesManager.filterByPriceBiggerThan(10.0).size());
    	Assertions.assertEquals(2, securitiesManager.filterByPriceBiggerThan(100.0).size());
    	Assertions.assertEquals(1, securitiesManager.filterByPriceBiggerThan(1000.0).size());
    }
    
    @Test
    void testFilterByPriceLowerThan() {
    	Assertions.assertEquals(5, securitiesManager.filterByPriceLowerThan(10000.0).size());
    	Assertions.assertEquals(4, securitiesManager.filterByPriceLowerThan(1000.0).size());
    	Assertions.assertEquals(3, securitiesManager.filterByPriceLowerThan(100.0).size());
    	Assertions.assertEquals(1, securitiesManager.filterByPriceLowerThan(10.0).size());
    	Assertions.assertEquals(1, securitiesManager.filterByPriceLowerThan(1.0).size());
    }
    
    @Test
    void testFilterByTrendEquals() {
    	Assertions.assertEquals(2, securitiesManager.filterByTrend(Trend.DOWN).size());
    	Assertions.assertEquals(3, securitiesManager.filterByTrend(Trend.UP).size());
    }
    
    @Test
    void testFilterByRiskLevelEquals() {
    	Assertions.assertEquals(1, securitiesManager.filterByRiskLevelEquals(RiskLevel.DANGER).size());
    	Assertions.assertEquals(1, securitiesManager.filterByRiskLevelEquals(RiskLevel.HIGH).size());
    	Assertions.assertEquals(1, securitiesManager.filterByRiskLevelEquals(RiskLevel.MEDIUM).size());
    	Assertions.assertEquals(2, securitiesManager.filterByRiskLevelEquals(RiskLevel.LOW).size());
    }
    
    @Test
    void testFilterByRiskLevelBiggerThan() {
    	Assertions.assertEquals(1, securitiesManager.filterByRiskLevelBiggerThan(RiskLevel.HIGH).size());
    	Assertions.assertEquals(2, securitiesManager.filterByRiskLevelBiggerThan(RiskLevel.MEDIUM).size());
    	Assertions.assertEquals(3, securitiesManager.filterByRiskLevelBiggerThan(RiskLevel.LOW).size());
    }
    
    @Test
    void testFilterByRiskLevelLowerThan() {
    	Assertions.assertEquals(4, securitiesManager.filterByRiskLevelLowerThan(RiskLevel.DANGER).size());
    	Assertions.assertEquals(3, securitiesManager.filterByRiskLevelLowerThan(RiskLevel.HIGH).size());
    	Assertions.assertEquals(2, securitiesManager.filterByRiskLevelLowerThan(RiskLevel.MEDIUM).size());
    }
    
    @Test
    void testSortPriceAscending() {
        SecuritiesManagerImpl.sortByPriceAscending(securities);
        Assertions.assertEquals(0, securities.get(0).getPricePerUnit());
    }
    
    @Test
    void testSortPriceDescending() {
        SecuritiesManagerImpl.sortByPriceDescending(securities);
        Assertions.assertEquals(2000, securities.get(0).getPricePerUnit());
    }
    
    @Test
    void testSortDurationAscending() {
        SecuritiesManagerImpl.sortByDurationAscending(securities);
        Assertions.assertEquals(0, securities.get(0).getDuration());
    }
    
    @Test
    void testSortDurationDescending() {
        SecuritiesManagerImpl.sortByDurationDescending(securities);
        Assertions.assertEquals(3000, securities.get(0).getDuration());
    }
}
