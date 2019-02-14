package ua.lviv.iot.security.models;

public class Debt extends Security {

	private String asset;
	private Security security;

	public Debt() {
	}

	public Debt(double pricePerUnit, String currency, RiskLevel riskLevel,
			Trend trend, double duration, String emitent,
			String owner, String asset, Security security) {
		super(pricePerUnit, currency, riskLevel, trend, duration, emitent, owner);
		this.asset = asset;
		this.security = security;
	}

	public String getAsset() {
		return asset;
	}

	public void setAsset(String asset) {
		this.asset = asset;
	}

	public Security getSecurity() {
		return security;
	}

	public void setSecurity(Security security) {
		this.security = security;
	}

}
