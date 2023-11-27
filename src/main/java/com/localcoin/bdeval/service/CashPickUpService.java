package com.localcoin.bdeval.service;

import com.localcoin.bdeval.entity.AtmCashPickupRange;
import com.localcoin.bdeval.repository.CashPickupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CashPickUpService {

    @Autowired
    private CashPickupRepository cashPickupRepository;

    public List<AtmCashPickupRange> findAtmCashPickupNonNullRanges() {
        return cashPickupRepository.findAtmCashPickupNonNullRanges();
    }
}
