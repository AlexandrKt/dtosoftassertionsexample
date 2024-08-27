package com.dtosoftassertionsexample.tests;

import com.dtosoftassertionsexample.config.EndPoints;
import com.dtosoftassertionsexample.helpers.ReadFromPropertiesHelper;
import com.dtosoftassertionsexample.model.ExchangeRate;
import com.dtosoftassertionsexample.model.ExchangeRates;
import com.dtosoftassertionsexample.utils.ApiUtil;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class CurrencyExchangeTest extends AbstractTest{

    @Test
    public void testExchangeRates() {
        ExchangeRates bankData;
        try {
            bankData = ReadFromPropertiesHelper.fromProperties("src/test/resources/rates.properties");
            List<ExchangeRate> exchangeRates = bankData.getExchangeRate();
            for (ExchangeRate rate : exchangeRates) {
                System.out.println("Currency: " + rate.getCurrency() +
                        ", Sale Rate NB: " + rate.getSaleRateNB() +
                        ", Purchase Rate NB: " + rate.getPurchaseRateNB() +
                        ", Sale Rate: " + rate.getSaleRate() +
                        ", Purchase Rate: " + rate.getPurchaseRate());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        SoftAssertions soft = new SoftAssertions();
        String date = "01.12.2014";

        ExchangeRates rates = new Gson().fromJson(ApiUtil.sendGetRequest(EndPoints.GET_EXCHANGE_RATES, date).asString(), ExchangeRates.class);
        //ExchangeRates rates = RestAssured.exrtact().as(ExchangeRates.class);
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
        soft.assertThat(rates).isEqualTo(initializeRate());
        soft.assertThat(rates).usingRecursiveComparison()
                .ignoringFields("date", "bank", "baseCurrency", "baseCurrencyLit")
                .isEqualTo(bankData);

        soft.assertAll();
    }
}
