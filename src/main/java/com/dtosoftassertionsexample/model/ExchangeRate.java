package com.dtosoftassertionsexample.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class ExchangeRate {
    public String baseCurrency;
    public String currency;
    public Double saleRateNB;
    public Double purchaseRateNB;
    public Double saleRate;
    public Double purchaseRate;
}
