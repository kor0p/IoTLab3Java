package ua.lviv.iot.security.models;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)  
@DiscriminatorColumn(name="type",discriminatorType=DiscriminatorType.STRING)  
@DiscriminatorValue(value="ParentClass") 
public class Security {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column
  private double pricePerUnit;
  @Column
  private String currency;
  @Column
  private RiskLevel riskLevel;
  @Column
  private Trend trend;
  @Column
  private double duration;
  @Column
  private String emitent;
  @Column
  private String owner;

  public Security() {
    super();
  }

  public Security(final double pricePerUnit, final String currency, final RiskLevel riskLevel, 
      final Trend trend, final double duration, final String emitent, final String owner) {
    this();
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
    return "Security [pricePerUnit=" + currency + pricePerUnit
      + ", riskLevel=" + riskLevel + ", trend=" + trend + ", duration="
      + duration + ", emitent=" + emitent + ", owner=" + owner + "]";
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
