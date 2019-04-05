package ua.lviv.iot.security.models;

public class Equity extends Security {

  private String company;
  private double percentOfCompany;

  public Equity() {
  }

  public Equity(final double pricePerUnit, final String currency, final RiskLevel riskLevel,
      final Trend trend, final double duration, final String emitent, final String owner,
      final String company, final double percentOfCompany) {
    super(pricePerUnit, currency, riskLevel, trend, duration, emitent, owner);
    this.company = company;
    this.percentOfCompany = percentOfCompany;
  }
  
  public String getCompany() {
    return company;
  }

  public void setCompany(final String company) {
    this.company = company;
  }

  public double getPercentOfCompany() {
    return percentOfCompany;
  }

  public void setPercentOfCompany(final double percentOfCompany) {
    this.percentOfCompany = percentOfCompany;
  }

}
