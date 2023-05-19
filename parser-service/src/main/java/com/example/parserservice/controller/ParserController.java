package com.example.parserservice.controller;

import com.example.parserservice.dto.CurrencyDto;
import com.example.parserservice.util.parser.Parser;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/parser")
public class ParserController {

    private final Parser parser;

    @GetMapping
    public List<CurrencyDto> getAllParsedRates() {
        return parser.getCurrencies();
    }
}
