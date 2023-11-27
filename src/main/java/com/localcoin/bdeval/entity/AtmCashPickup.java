package com.localcoin.bdeval.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Table(name = "atm_cash_pickup", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "atm_identifier", "expected_pickup" }) })
@Entity
public class AtmCashPickup {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;

	@NotNull
	@Column(name = "atm_identifier")
	private String atmIdentifier;

	@NotNull
	@Column(name = "expected_pickup")
	private LocalDate expectedPickup;

	@Column(name = "actual_pickup")
	private LocalDate actualPickup;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAtmIdentifier() {
		return atmIdentifier;
	}

	public void setAtmIdentifier(String atmIdentifier) {
		this.atmIdentifier = atmIdentifier;
	}

	public LocalDate getExpectedPickup() {
		return expectedPickup;
	}

	public void setExpectedPickup(LocalDate expectedPickup) {
		this.expectedPickup = expectedPickup;
	}

	public LocalDate getActualPickup() {
		return actualPickup;
	}

	public void setActualPickup(LocalDate actualPickup) {
		this.actualPickup = actualPickup;
	}
}
