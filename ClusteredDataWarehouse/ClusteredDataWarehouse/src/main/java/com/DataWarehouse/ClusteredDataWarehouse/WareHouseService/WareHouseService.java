package com.DataWarehouse.ClusteredDataWarehouse.WareHouseService;

import com.DataWarehouse.ClusteredDataWarehouse.DTO.DealDTO;
import com.DataWarehouse.ClusteredDataWarehouse.Model.Deals;

import java.util.List;

public interface WareHouseService {

    public List<Deals> getAllDeals();

    public String addNewDeal(DealDTO newDeal);

}
