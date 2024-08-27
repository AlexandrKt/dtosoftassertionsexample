package com.dtosoftassertionsexample.model;

import lombok.*;

@Getter @Setter @ToString @EqualsAndHashCode @AllArgsConstructor
public class ExchangeRate {
    public String baseCurrency;
    public String currency;
    public Double saleRateNB;
    public Double purchaseRateNB;
    public Double saleRate;
    public Double purchaseRate;
}
