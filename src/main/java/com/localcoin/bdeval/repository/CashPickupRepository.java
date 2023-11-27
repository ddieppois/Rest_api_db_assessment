package com.localcoin.bdeval.repository;

import com.localcoin.bdeval.entity.AtmCashPickup;
import com.localcoin.bdeval.entity.AtmCashPickupRange;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CashPickupRepository extends CrudRepository<AtmCashPickup, Integer> {

    //Query to retrieve all the date ranges which each non-null actual_pickup covers from atm_cash_pickup.
    @Query(
            value = "select atm_identifier atm, min(expected_pickup) startDate, max(actual_pickup) endDate\n" +
                    "from (select atm_cash_pickup.*,\n" +
                    "             count(actual_pickup) over (partition by atm_identifier order by expected_pickup desc) as grp\n" +
                    "      from atm_cash_pickup\n" +
                    "     ) atm_cash_pickup\n" +
                    "group by atm_identifier, grp;",
            nativeQuery = true)
    List<AtmCashPickupRange> findAtmCashPickupNonNullRanges();

}
