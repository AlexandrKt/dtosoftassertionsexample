package com.dtosoftassertionsexample.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Getter
@Setter
@ToString
public class ExchangeRates {
    public String date;
    public String bank;
    public int baseCurrency;
    public String baseCurrencyLit;
    public List<ExchangeRate> exchangeRate;
}
