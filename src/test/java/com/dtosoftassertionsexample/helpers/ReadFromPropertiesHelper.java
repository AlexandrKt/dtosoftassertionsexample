package com.dtosoftassertionsexample.helpers;

import com.dtosoftassertionsexample.model.ExchangeRates;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.mapper.ObjectMapper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class ReadFromPropertiesHelper {
    public static ExchangeRates fromProperties(String propertiesFilePath) throws IOException {
        Properties properties = new Properties();
        try (InputStream input = new FileInputStream(propertiesFilePath)) {
            properties.load(input);
            String json = properties.getProperty("rates.json");
/*

                // Parsing the JSON string to a JsonObject
                JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

                // Extracting values

           /* String date = jsonObject.get("date").getAsString();
            String bank = jsonObject.get("bank").getAsString();
            int baseCurrency= jsonObject.get("baseCurrency").getAsInt();
            String baseCurrencyLit = jsonObject.get("baseCurrencyLit").getAsString();*/


            if (json != null && !json.trim().isEmpty()) {
                Gson gson = new Gson();

                // Parse JSON string to ExchangeRates object
                return gson.fromJson(json, ExchangeRates.class);
            }
        }
        return null; // Return null if no valid JSON found
        }
    }

