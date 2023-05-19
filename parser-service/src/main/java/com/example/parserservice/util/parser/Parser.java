package com.example.parserservice.util.parser;

import com.example.parserservice.dto.CurrencyDto;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.print.Doc;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class Parser {

//    @Value("${minfin.url}")
    private final String minfinUrl;
//    private final Document html;


    public Parser(@Value("${minfin.url}") String minfinUrl) {
        this.minfinUrl = minfinUrl;
    }

    private Document getHtml() {
        Document html = null;
        try {
            html = Jsoup.connect(minfinUrl).get();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return html;
    }

    private List<String> getRates(Document html) {
        var rates = new ArrayList<String>();
        var ratesElements = html.getElementsByClass("mfcur-nbu-full-wrap");
        ratesElements.forEach(element -> rates.add(getOnlyCurrencyCost(element)));
        return rates;
    }

    private String getOnlyCurrencyCost(Element element) {
        var currencyCost = element.text().substring(0, 7);
        return currencyCost;
    }

    private List<String> getCurrenciesCodes(Document html) {
        var codes = new ArrayList<String>();
        var codesElements = html.getElementsByClass("mfcur-table-cur");
        codesElements.forEach(element -> {
            var links = element.getElementsByTag("a");
            links.forEach(link -> {
                var buffer = link.attr("href").replace("currency/banks/", "");
                var name = buffer.replaceAll("/", "");
                codes.add(name);
            });
        });
        return codes;
    }

    public List<CurrencyDto> getCurrencies() {
        var html = getHtml();
        var allCurrencies = new ArrayList<CurrencyDto>();
        var rates = getRates(html);
        var currenciesCodes = getCurrenciesCodes(html);
        allCurrencies.add(new CurrencyDto(1d, "uah"));
        for (int i = 0; i < rates.size(); i++) {
            var currencyCode = currenciesCodes.get(i);
            var currencyRate = Double.parseDouble(rates.get(i));
            allCurrencies.add(new CurrencyDto(currencyRate, currencyCode));
        }
        return allCurrencies;
    }

}
