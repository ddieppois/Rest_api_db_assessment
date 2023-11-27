package com.localcoin.bdeval.entity;

import java.time.LocalDate;

public interface AtmCashPickupRange {

    String getAtm();
    LocalDate getStartDate();
    LocalDate getEndDate();
}
