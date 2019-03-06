package ua.lviv.iot.security.models;

public class Security {

  private double pricePerUnit;
  private String currency;
  private RiskLevel riskLevel;
  private Trend trend;
  private double duration;
  private String emitent;
  private String owner;

  public Security() {
    super();
  }

  public Security(final double pricePerUnit, final String currency,
      final RiskLevel riskLevel, final Trend trend, final double duration,
      final String emitent, final String owner) {
    super();
    this.pricePerUnit = pricePerUnit;
    this.currency = currency;
    this.riskLevel = riskLevel;
    this.trend = trend;
    this.duration = duration;
    this.emitent = emitent;
    this.owner = owner;
  }

  public String toString() {
    return "Security: \n[\n  " + getHeaders() + "\n  " + toCSV() + "\n]\n";
  }

  public String getHeaders() {
    return "pricePerUnit" + "," + "currency" + "," + "riskLevel" + ","
        + "trend" + "," + "duration" + "," + "emitent" + "," + "owner";
  }

  public String toCSV() {
    return pricePerUnit + "," + currency + "," + riskLevel
        + "," + trend + "," + duration + "," + emitent + "," + owner;
  }

  public double getPricePerUnit() {
    return pricePerUnit;
  }

  public void setPricePerUnit(final double pricePerUnit) {
    this.pricePerUnit = pricePerUnit;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(final String currency) {
    this.currency = currency;
  }

  public RiskLevel getRiskLevel() {
    return riskLevel;
  }

  public void setRiskLevel(final RiskLevel riskLevel) {
    this.riskLevel = riskLevel;
  }

  public Trend getTrend() {
    return trend;
  }

  public void setTrend(final Trend trend) {
    this.trend = trend;
  }

  public double getDuration() {
    return duration;
  }

  public void setDuration(final double duration) {
    this.duration = duration;
  }

  public String getEmitent() {
    return emitent;
  }

  public void setEmitent(final String emitent) {
    this.emitent = emitent;
  }

  public String getOwner() {
    return owner;
  }

  public void setOwner(final String owner) {
    this.owner = owner;
  }
}
