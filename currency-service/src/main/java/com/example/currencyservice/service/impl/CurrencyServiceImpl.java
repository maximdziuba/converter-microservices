package com.example.currencyservice.service.impl;

import com.example.currencyservice.client.ParserClient;
import com.example.currencyservice.dto.CurrencyDto;
import com.example.currencyservice.exception.CurrencyNotFoundException;
import com.example.currencyservice.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

    private final ParserClient parserClient;

    @Override
    public List<CurrencyDto> getAllCurrencies() {
        return parserClient.getAllCurrencies();
    }

    @Override
    public CurrencyDto getCurrencyByCode(String code) {
        var currencies = getAllCurrencies();
        return currencies.stream().filter(currency -> currency.currencyCode().equals(code)).findFirst()
                .orElseThrow(() -> new CurrencyNotFoundException("The currency wasn't found"));
    }
}
