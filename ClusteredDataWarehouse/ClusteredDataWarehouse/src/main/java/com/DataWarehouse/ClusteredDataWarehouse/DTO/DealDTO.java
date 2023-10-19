package com.DataWarehouse.ClusteredDataWarehouse.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class DealDTO {

    private String fromIso;

    private String toIso;

    private LocalDateTime dealDate;

    private double amount;
}
