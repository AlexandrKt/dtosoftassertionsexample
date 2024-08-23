package com.dtosoftassertionsexample.tests;

import com.dtosoftassertionsexample.model.ExchangeRates;
import com.dtosoftassertionsexample.utils.ApiUtil;
import com.google.gson.Gson;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

public class CurrencyExchangeTest {

    @Test
    public void testExchangeRates() {
        SoftAssertions soft = new SoftAssertions();
        String endpoint = "https://api.privatbank.ua/p24api/exchange_rates?json&date=01.12.2014";

        ExchangeRates rates = new Gson().fromJson(ApiUtil.sendGetRequest(endpoint).asString(), ExchangeRates.class);

        // Assertions using ExchangeRates object
        soft.assertThat(rates.date).isEqualTo("01.12.2014");
        soft.assertThat(rates.exchangeRate).isNotNull()
                .overridingErrorMessage("Exchange rates list should not be null");

        // Example of checking a specific currency detail
        rates.exchangeRate.stream()
                .filter(rate -> "USD".equals(rate.currency))
                .findFirst()
                .ifPresent(rate -> {
                    soft.assertThat(rate.saleRateNB).isEqualTo(15.05641);
                    soft.assertThat(rate.purchaseRateNB).isEqualTo(15.05641);
                });
        rates.exchangeRate.stream()
                .filter(rate -> "EUR".equals(rate.currency))
                .findFirst()
                .ifPresent(rate -> {
                    soft.assertThat(rate.saleRateNB).isEqualTo(15.05641);
                    soft.assertThat(rate.purchaseRateNB).isEqualTo(15.05641);
                });

        soft.assertAll();
    }
}
