package com.DataWarehouse.ClusteredDataWarehouse.WarehouseRepository;

import com.DataWarehouse.ClusteredDataWarehouse.Model.Deals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WareHouseRepository extends JpaRepository<Deals, Long> {
}
