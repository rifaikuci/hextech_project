package com.rifaikuci.hextech_project.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    //GET işlemlerinin yapılacağı alan burada belirlenir
    //Gradle dosyasına 2 adet impletion işlemi yapılır.

    private static final String BASE_URL = "https://rifaikuci.com/hextech/";
    private static Retrofit retrofit;

    public static Retrofit getApiClient() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
