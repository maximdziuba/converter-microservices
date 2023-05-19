package com.example.converterservice.service;

import com.example.converterservice.dto.ResponseDto;

public interface ConverterService {
    ResponseDto countRateByUah(String fromCurrencyCode, String toCurrencyCode, Double value);
}
