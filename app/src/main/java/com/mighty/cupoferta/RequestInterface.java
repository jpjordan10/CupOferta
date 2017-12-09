package com.mighty.cupoferta;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by jeanp on 07/12/2017.
 */

public interface RequestInterface {
    @GET("/cupones//YLabhnB")
    Call<JSONResponse> getJSON();
}
