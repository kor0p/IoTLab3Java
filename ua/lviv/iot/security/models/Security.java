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
	}

	public Security(double pricePerUnit, String currency, RiskLevel riskLevel, 
			Trend trend, double duration,String emitent, String owner) {
		super();
		this.pricePerUnit = pricePerUnit;
		this.currency = currency;
		this.riskLevel = riskLevel;
		this.trend = trend;
		this.duration = duration;
		this.emitent = emitent;
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Security [pricePerUnit=" + pricePerUnit + " " + currency +
				", riskLevel=" + riskLevel+ ", trend=" + trend + ", duration=" +
				duration + ", emitent=" + emitent + ", owner=" + owner + "]";
	}

	public double getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public RiskLevel getRiskLevel() {
		return riskLevel;
	}

	public void setRiskLevel(RiskLevel riskLevel) {
		this.riskLevel = riskLevel;
	}

	public Trend getTrend() {
		return trend;
	}

	public void setTrend(Trend trend) {
		this.trend = trend;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public String getEmitent() {
		return emitent;
	}

	public void setEmitent(String emitent) {
		this.emitent = emitent;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
}
