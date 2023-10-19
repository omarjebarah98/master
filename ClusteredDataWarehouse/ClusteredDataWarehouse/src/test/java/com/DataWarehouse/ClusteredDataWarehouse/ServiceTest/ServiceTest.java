package com.DataWarehouse.ClusteredDataWarehouse.ServiceTest;

import com.DataWarehouse.ClusteredDataWarehouse.DTO.DealDTO;
import com.DataWarehouse.ClusteredDataWarehouse.Model.Deals;
import com.DataWarehouse.ClusteredDataWarehouse.WareHouseService.WareHouseService;
import com.DataWarehouse.ClusteredDataWarehouse.WareHouseServiceImpl.WareHouseServiceImpl;
import com.DataWarehouse.ClusteredDataWarehouse.WarehouseRepository.WareHouseRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ServiceTest {

    @Mock
    private WareHouseRepository wareHouseRepository;

    @InjectMocks
    private WareHouseServiceImpl dealsService;

    @Test
    public void testGetAllDeals() {
        Deals deal1 = Deals.builder().dealId(1L).build();
        Deals deal2 = Deals.builder().dealId(2L).build();

        List<Deals> deals = new ArrayList<>();
        deals.add(deal1);
        deals.add(deal2);

        when(wareHouseRepository.findAll()).thenReturn(deals);

        List<Deals> result = dealsService.getAllDeals();

        assertEquals(2, result.size());
    }

    @Test
    public void addDealFailed() {
        DealDTO newDeal = DealDTO.builder().toIso("JOD").fromIso("USD")
                .amount(5).build();

        Deals deal1 = Deals.builder().dealId(1L).toIso("JOD").fromIso("USD")
                .amount(5).build();
        Deals deal2 = Deals.builder().dealId(2L).toIso("AFN").fromIso("USD")
                .amount(5).build();

        List<Deals> deals = new ArrayList<>();
        deals.add(deal1);
        deals.add(deal2);

        when(wareHouseRepository.findAll()).thenReturn(deals);
        String result = dealsService.addNewDeal(newDeal);
        assertEquals("this deal already exist", result);
    }

    @Test
    public void addDealSuccess() {
        DealDTO newDeal = DealDTO.builder().toIso("ADS").fromIso("TUF")
                .amount(5).build();

        Deals deal1 = Deals.builder().dealId(1L).toIso("JOD").fromIso("USD")
                .amount(5).build();
        Deals deal2 = Deals.builder().dealId(2L).toIso("AFN").fromIso("USD")
                .amount(5).build();

        List<Deals> deals = new ArrayList<>();
        deals.add(deal1);
        deals.add(deal2);

        when(wareHouseRepository.findAll()).thenReturn(deals);
        String result = dealsService.addNewDeal(newDeal);
        assertEquals("new deal added successfully", result);
    }
}
