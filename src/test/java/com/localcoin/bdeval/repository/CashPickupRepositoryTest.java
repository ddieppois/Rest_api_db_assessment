package com.localcoin.bdeval.repository;

import com.localcoin.bdeval.entity.AtmCashPickupRange;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class CashPickupRepositoryTest {

    @Autowired
    private CashPickupRepository cashPickupRepository;

    @Test
    void findAtmCashPickupNonNullRanges() {
        List<AtmCashPickupRange> atmList = cashPickupRepository.findAtmCashPickupNonNullRanges();
        assertNotNull(atmList);
        AtmCashPickupRange atmCashPickupRange = atmList.get(0);
        assertEquals("ATM1", atmCashPickupRange.getAtm());
        assertEquals("2019-04-26", atmCashPickupRange.getStartDate().toString());
        assertEquals("2019-05-17", atmCashPickupRange.getEndDate().toString());
        atmCashPickupRange = atmList.get(1);
        assertEquals("ATM1", atmCashPickupRange.getAtm());
        assertEquals("2019-03-10", atmCashPickupRange.getStartDate().toString());
        assertEquals("2019-04-23", atmCashPickupRange.getEndDate().toString());
        atmCashPickupRange = atmList.get(2);
        assertEquals("ATM2", atmCashPickupRange.getAtm());
        assertEquals("2019-05-20", atmCashPickupRange.getStartDate().toString());
        assertEquals("2019-05-23", atmCashPickupRange.getEndDate().toString());
        atmCashPickupRange = atmList.get(3);
        assertEquals("ATM2", atmCashPickupRange.getAtm());
        assertEquals("2019-05-10", atmCashPickupRange.getStartDate().toString());
        assertEquals("2019-05-16", atmCashPickupRange.getEndDate().toString());
        atmCashPickupRange = atmList.get(4);
        assertEquals("ATM2", atmCashPickupRange.getAtm());
        assertEquals("2019-02-20", atmCashPickupRange.getStartDate().toString());
        assertEquals("2019-03-13", atmCashPickupRange.getEndDate().toString());
    }
}