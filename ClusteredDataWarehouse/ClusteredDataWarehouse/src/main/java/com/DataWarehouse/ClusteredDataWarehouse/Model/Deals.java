package com.DataWarehouse.ClusteredDataWarehouse.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "deals")
public class Deals {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "deal_id")  // Specify the column name
    private Long dealId;

    @Column(name = "from_iso")  // Specify the column name
    private String fromIso;

    @Column(name = "to_iso")  // Specify the column name
    private String toIso;

    @Column(name = "deal_date")  // Specify the column name
    private LocalDateTime dealDate;

    private double amount;
}
