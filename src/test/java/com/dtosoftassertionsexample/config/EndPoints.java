package com.dtosoftassertionsexample.config;

public interface EndPoints {
    String BASE_URL = "https://api.privatbank.ua";
    String GET_EXCHANGE_RATES = BASE_URL + "/p24api/exchange_rates";
    String POSTS_BY_USER = BASE_URL + "/api/postsByAuthor/{0}";
    String LOGIN = BASE_URL + "/api/login";
    String CREATE_POST = BASE_URL + "/api/create-post";
    String DELETE_POST = BASE_URL + "/api/post/{0}";

}
