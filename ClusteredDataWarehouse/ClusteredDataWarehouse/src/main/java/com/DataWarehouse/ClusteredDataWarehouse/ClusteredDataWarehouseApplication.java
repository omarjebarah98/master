package com.DataWarehouse.ClusteredDataWarehouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EntityScan
public class ClusteredDataWarehouseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClusteredDataWarehouseApplication.class, args);
	}

}
