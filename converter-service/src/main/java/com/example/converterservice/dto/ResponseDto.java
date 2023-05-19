package com.example.converterservice.dto;

public record ResponseDto(String fromCurrencyCode, String toCurrencyCode, Double value, Double result) {
}
