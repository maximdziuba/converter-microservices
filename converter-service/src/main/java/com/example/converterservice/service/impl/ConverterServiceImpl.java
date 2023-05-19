package com.example.converterservice.service.impl;

import com.example.converterservice.client.CurrencyClient;
import com.example.converterservice.dto.CurrencyDto;
import com.example.converterservice.dto.ResponseDto;
import com.example.converterservice.service.ConverterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Currency;

@Service
@RequiredArgsConstructor
public class ConverterServiceImpl implements ConverterService {

    private final CurrencyClient currencyClient;

    @Override
    public ResponseDto countRateByUah(String fromCurrencyCode, String toCurrencyCode, Double value) {
        var currencies = currencyClient.getAllCurrencies();
        CurrencyDto fromFilteredCurrency = null;
        CurrencyDto toFilteredCurrency = null;
//        for (var currency1 : currencies) {
//            if (currency1.currencyCode().equals(fromCurrencyCode)) {
//                fromFilteredCurrency = currency1;
//            }
//        }
//        for (var currency : currencies) {
//            if (currency.currencyCode().equals(toCurrencyCode)) {
//                toFilteredCurrency = currency;
//            }
//        }

        for (var currentCurrency : currencies) {
            if (currentCurrency.currencyCode().equals(fromCurrencyCode)) {
                fromFilteredCurrency = currentCurrency;
            } else if (currentCurrency.currencyCode().equals(toCurrencyCode)) {
                toFilteredCurrency = currentCurrency;
            }
        }

        var foreignCurrencyRate = value / (toFilteredCurrency.rateByUah() / fromFilteredCurrency.rateByUah());
        return new ResponseDto(fromCurrencyCode, toCurrencyCode, value, foreignCurrencyRate);
    }
}
