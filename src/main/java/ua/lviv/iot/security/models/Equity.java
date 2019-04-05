package ua.lviv.iot.security.models;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@DiscriminatorValue("childClasss")
public class Equity extends Security {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  
  @Column
  private String company;
  @Column
  private double percentOfCompany;

  public Equity() {
	  super();
  }

  public Equity(final double pricePerUnit, final String currency, final RiskLevel riskLevel,
      final Trend trend, final double duration, final String emitent, final String owner,
      final String company, final double percentOfCompany) {
    super(pricePerUnit, currency, riskLevel, trend, duration, emitent, owner);
    this.company = company;
    this.percentOfCompany = percentOfCompany;
  }
  
  @Override
  public String toString() {
	  return "Equity [" + super.toString() + ", company="+company
			  + ", percentOfCompany=" + percentOfCompany + "]";
  }
  
  public Integer getId() {
	  return id;
  }
  
  public void setId(Integer id) {
	  this.id = id;
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
