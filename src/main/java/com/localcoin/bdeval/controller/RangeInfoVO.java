package com.localcoin.bdeval.controller;

import com.localcoin.bdeval.entity.AtmCashPickup;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RangeInfoVO {

	public RangeInfoVO(String atm, List<Range> ranges) {
		super();
		this.atm = atm;
		this.ranges = ranges;
	}

	private String atm;
	private List<Range> ranges = new ArrayList<Range>();

	public String getAtm() {
		return atm;
	}

	public void setAtm(String atm) {
		this.atm = atm;
	}

	public List<Range> getRanges() {
		return ranges;
	}

	public void setRanges(List<Range> ranges) {
		this.ranges = ranges;
	}

	public void addRange(Range range) { this.ranges.add(range); }

}

class Range {

	public Range(LocalDate start_date, LocalDate end_date) {
		this.start_date = start_date;
		this.end_date = end_date;
	}

	private LocalDate start_date;

	private LocalDate end_date;

	public LocalDate getStart_date() {
		return start_date;
	}

	public void setStart_date(LocalDate start_date) {
		this.start_date = start_date;
	}

	public LocalDate getEnd_date() {
		return end_date;
	}

	public void setEnd_date(LocalDate end_date) {
		this.end_date = end_date;
	}
}