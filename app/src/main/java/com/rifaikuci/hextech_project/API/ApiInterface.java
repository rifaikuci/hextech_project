package com.rifaikuci.hextech_project.API;

import com.rifaikuci.hextech_project.datas.Pins;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiInterface {

    @GET("values.php")
    Call<List<Pins>> getValues();
}
