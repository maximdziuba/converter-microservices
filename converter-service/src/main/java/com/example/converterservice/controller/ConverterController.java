package com.example.converterservice.controller;

import com.example.converterservice.dto.ResponseDto;
import com.example.converterservice.service.ConverterService;
import feign.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/converter")
@RequiredArgsConstructor
public class ConverterController {

    private final ConverterService converterService;

    @GetMapping
    public ResponseDto convertByUah(@RequestParam("from") String from, @RequestParam("to") String to, @RequestParam("value") Double value) {
        return converterService.countRateByUah(from, to, value);
    }
}
