package com.example.restrictedapi;

//@EnableAccessRestrictedApi
public class RestrictedApiApplication {

    public static void main(String[] args) {
        RestrictedApiService restrictedApiService = new RestrictedApiService();
        restrictedApiService.restrictedMethod();
    }

}
