package com.DataWarehouse.ClusteredDataWarehouse.WareHouseServiceImpl;

import com.DataWarehouse.ClusteredDataWarehouse.DTO.DealDTO;
import com.DataWarehouse.ClusteredDataWarehouse.Model.Deals;
import com.DataWarehouse.ClusteredDataWarehouse.WareHouseService.WareHouseService;
import com.DataWarehouse.ClusteredDataWarehouse.WarehouseRepository.WareHouseRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Log4j2
public class WareHouseServiceImpl implements WareHouseService {

    @Autowired
    WareHouseRepository wareHouseRepository;

    @Override
    public List<Deals> getAllDeals() {
        log.info("get all the deals from DB");
        List<Deals> deals = wareHouseRepository.findAll();
        return deals;
    }

    @Override
    public String addNewDeal(DealDTO newDeal) {
        List<Deals> deals = wareHouseRepository.findAll();

        Optional<Deals> existDeal = deals.stream().filter(d -> d.getFromIso().equals(newDeal.getFromIso()) &&
            d.getToIso().equals(newDeal.getToIso())).findAny();

        if(existDeal.isPresent() && Objects.nonNull(existDeal.get())) {
            log.error("you can't add existing deal");
            return "this deal already exist";
        }

        log.info("the new deal is not exist on DB");
        Deals deal = Deals.builder().fromIso(newDeal.getFromIso()).toIso(newDeal.getToIso())
                .dealDate(LocalDateTime.now()).amount(newDeal.getAmount()).build();
        wareHouseRepository.save(deal);
        return "new deal added successfully";
    }

}
