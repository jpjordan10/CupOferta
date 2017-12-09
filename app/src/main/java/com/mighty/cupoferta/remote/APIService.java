package com.mighty.cupoferta.remote;

import com.mighty.cupoferta.model.Usuario;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by jeanp on 08/12/2017.
 */

public interface APIService {
    @POST("/usuario")
    @FormUrlEncoded
    Call<Usuario> saveUser(@Field("nombres") String nombres,
                           @Field("apellidos") String apellidos,
                           @Field("email") String email,
                           @Field("dni") String dni,
                           @Field("password") String password);
}
