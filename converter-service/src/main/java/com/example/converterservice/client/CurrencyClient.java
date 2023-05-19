package com.example.converterservice.client;

import com.example.converterservice.dto.CurrencyDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "currency-service")
public interface CurrencyClient {

    @GetMapping("/currency")
    List<CurrencyDto> getAllCurrencies();

}
