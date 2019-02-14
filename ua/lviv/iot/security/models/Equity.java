package ua.lviv.iot.security.models;

public class Equity extends Security {

	private String company;
	private double percentOfCompany;

	public Equity() {
	}

	public Equity(double pricePerUnit, String currency, RiskLevel riskLevel,
			Trend trend, double duration,String emitent, String owner,
			String company, double percentOfCompany) {
		super(pricePerUnit, currency, riskLevel, trend, duration, emitent, owner);
		this.company = company;
		this.percentOfCompany = percentOfCompany;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public double getPercentOfCompany() {
		return percentOfCompany;
	}

	public void setPercentOfCompany(double percentOfCompany) {
		this.percentOfCompany = percentOfCompany;
	}

}
