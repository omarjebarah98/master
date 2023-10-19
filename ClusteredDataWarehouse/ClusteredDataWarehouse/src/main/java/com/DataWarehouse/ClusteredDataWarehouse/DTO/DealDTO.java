package com.DataWarehouse.ClusteredDataWarehouse.DTO;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class DealDTO {

    @NonNull
    @Pattern(regexp = "^[A-Z]{3}$", message = "Invalid ISO format")
    private String fromIso;

    @NonNull
    @Pattern(regexp = "^[A-Z]{3}$", message = "Invalid ISO format")
    private String toIso;

    private LocalDateTime dealDate;

    private double amount;
}
