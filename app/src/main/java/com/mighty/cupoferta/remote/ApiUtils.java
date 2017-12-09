package com.mighty.cupoferta.remote;

/**
 * Created by jeanp on 08/12/2017.
 */

public class ApiUtils {
    private ApiUtils() {
    }

    public static final String BASE_URL = "http://192.168.1.42:3000/";

    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
