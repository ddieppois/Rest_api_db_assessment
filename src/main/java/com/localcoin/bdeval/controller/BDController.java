package com.localcoin.bdeval.controller;

import com.localcoin.bdeval.entity.AtmCashPickupRange;
import com.localcoin.bdeval.service.CashPickUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/v1")
public class BDController {

    @Autowired
    private CashPickUpService cashPickUpService;

    @ResponseBody
    @GetMapping(path = "/search_ranges", produces = "application/json")
    public List<RangeInfoVO> searchRanges() {
        List<AtmCashPickupRange> AtmCashPickupRangeList = cashPickUpService.findAtmCashPickupNonNullRanges();
        assert !AtmCashPickupRangeList.isEmpty() : null;
        return convertPickUpRangesToRangeInfo(AtmCashPickupRangeList);
    }

    /**
     * Function to convert a list of AtmCashPickupRange to RangeInfoVO.
     *
     * @param AtmCashPickupRangeList original list of AtmCashPickupRange result from atm service
     * @return complete list of RangeInfoVo from original list
     */
    private List<RangeInfoVO> convertPickUpRangesToRangeInfo(List<AtmCashPickupRange> AtmCashPickupRangeList) {
        List<RangeInfoVO> result = new ArrayList<>();
        Map<String, List<Range>> AtmCashPickupRangeMap = new HashMap<>();
        for (AtmCashPickupRange AtmCashPickupRange : AtmCashPickupRangeList) {
            List<Range> rangeList = AtmCashPickupRangeMap.get(AtmCashPickupRange.getAtm());
            if (rangeList == null) {
                AtmCashPickupRangeMap.put(AtmCashPickupRange.getAtm(), new ArrayList<>(Arrays.asList(new Range(AtmCashPickupRange.getStartDate(), AtmCashPickupRange.getEndDate()))));
            } else {
                rangeList.add(new Range(AtmCashPickupRange.getStartDate(), AtmCashPickupRange.getEndDate()));
            }
        }
        for (Map.Entry AtmCashPickupRangeMapEntry : AtmCashPickupRangeMap.entrySet()) {
            result.add(new RangeInfoVO((String) AtmCashPickupRangeMapEntry.getKey(), (List<Range>) AtmCashPickupRangeMapEntry.getValue()));
        }

        return result;
    }

}
