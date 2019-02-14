package ua.lviv.iot.security.models;

public class Derivative extends Security {

	private String asset;

	public Derivative() {
	}

	public Derivative(double pricePerUnit, String currency, RiskLevel riskLevel,
			Trend trend, double duration, String emitent, String owner, String asset) {
		super(pricePerUnit, currency, riskLevel, trend, duration, emitent, owner);
		this.asset = asset;
	}

	public String getAsset() {
		return asset;
	}

	public void setAsset(String asset) {
		this.asset = asset;
	}

}
