package com.example.restrictedapi;

import com.google.errorprone.annotations.RestrictedApi;

public class RestrictedApiService {
    @RestrictedApi(explanation = "This is a restricted method", allowlistAnnotations = EnableAccessRestrictedApi.class)
    public void restrictedMethod() {
        System.out.println("This is a restricted method");
    }
}
