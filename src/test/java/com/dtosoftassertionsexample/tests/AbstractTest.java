package com.dtosoftassertionsexample.tests;

import com.dtosoftassertionsexample.model.ExchangeRate;
import com.dtosoftassertionsexample.model.ExchangeRates;

import java.util.ArrayList;
import java.util.List;

public class AbstractTest {

    public ExchangeRates initializeRate(){
        List<ExchangeRate> exchangeRateList = new ArrayList<>();
        ExchangeRate exR = new ExchangeRate("UAH","AUD",12.8319250,12.8319250, null, null);
        exchangeRateList.add(exR);
        ExchangeRates exRs = new ExchangeRates("01.12.2014","PB",980,"UAH", exchangeRateList);

        return exRs;
    }
}
