package com.DataWarehouse.ClusteredDataWarehouse.ControllerService;

import com.DataWarehouse.ClusteredDataWarehouse.DTO.DealDTO;
import com.DataWarehouse.ClusteredDataWarehouse.Model.Deals;
import com.DataWarehouse.ClusteredDataWarehouse.WareHouseService.WareHouseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/deals")
@Validated
public class WareHouseController {

    @Autowired
    WareHouseService wareHouseService;

    @GetMapping("/all")
    public List<Deals> getAllDeals() {
        return wareHouseService.getAllDeals();
    }

    @PostMapping("/newDeal")
    public String addNewDeal(@RequestBody DealDTO newDeal) {
        return wareHouseService.addNewDeal(newDeal);
    }
}
