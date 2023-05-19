package com.example.currencyservice.service;

import com.example.currencyservice.dto.CurrencyDto;

import java.util.List;

public interface CurrencyService {
    List<CurrencyDto> getAllCurrencies();

    CurrencyDto getCurrencyByCode(String code);
}
