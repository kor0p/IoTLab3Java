package ua.lviv.iot.security.models;

public class Derivative extends Security {

  private String asset;

  public Derivative() {
    super();
  }

  public Derivative(final double pricePerUnit, final String currency, final RiskLevel riskLevel,
      final Trend trend,final double duration, final String emitent, final String owner,
      final String asset) {
    super(pricePerUnit, currency, riskLevel, trend, duration, emitent, owner);
    this.asset = asset;
  }

  public String getAsset() {
    return asset;
  }

  public void setAsset(final String asset) {
    this.asset = asset;
  }

}
