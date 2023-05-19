package com.example.currencyservice.controller;

import com.example.currencyservice.client.ParserClient;
import com.example.currencyservice.dto.CurrencyDto;
import com.example.currencyservice.service.CurrencyService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/currency")
@RequiredArgsConstructor
public class CurrencyController {

    private final CurrencyService currencyService;

    @GetMapping
    public List<CurrencyDto> getAllCurrencies() {
        return currencyService.getAllCurrencies();
    }

    @GetMapping("/{code}")
    public CurrencyDto getCurrencyByCode(@PathVariable("code") String code) {
        return currencyService.getCurrencyByCode(code);
    }
}
