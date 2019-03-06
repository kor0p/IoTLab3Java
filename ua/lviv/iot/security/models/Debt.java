package ua.lviv.iot.security.models;

public class Debt extends Security {

  private String asset;
  private Security security;

  public Debt() {
    super();
  }

  public Debt(final double pricePerUnit, final String currency,
      final RiskLevel riskLevel, final Trend trend,
      final double duration, final String emitent, final String owner,
      final String asset, final Security security) {
    super(pricePerUnit, currency, riskLevel, trend, duration, emitent, owner);
    this.asset = asset;
    this.security = security;
  }

  public String getHeaders() {
    return super.getHeaders() + "," + "asset" + "," + "secutity";
  }

  public String toCSV() {
    return super.toCSV() + "," + asset + "," + security;
  }

  public String getAsset() {
    return asset;
  }

  public void setAsset(final String asset) {
    this.asset = asset;
  }

  public Security getSecurity() {
    return security;
  }

  public void setSecurity(final Security security) {
    this.security = security;
  }

}
