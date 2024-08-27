package com.dtosoftassertionsexample.model;

import lombok.*;

import java.util.List;
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class ExchangeRates {
    public String date;
    public String bank;
    public int baseCurrency;
    public String baseCurrencyLit;
    public List<ExchangeRate> exchangeRate;
}
