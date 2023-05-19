package com.example.currencyservice.client;

import com.example.currencyservice.dto.CurrencyDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "parser-service")
public interface ParserClient {

    @GetMapping("/parser")
    List<CurrencyDto> getAllCurrencies();
}
