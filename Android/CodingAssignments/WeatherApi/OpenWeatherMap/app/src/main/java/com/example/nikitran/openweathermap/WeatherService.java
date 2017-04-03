package com.example.nikitran.openweathermap;

import com.example.nikitran.openweathermap.Data.Forecast;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Created by nikitran on 4/3/17.
 */

public class WeatherService {

    // 1. Define the static factory class:
    public static class Factory{
        public static final String BASE_URL = "http://api.openweathermap.org/";

        public static Retrofit create(){
            Interceptor interceptor = new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request request = chain.request()
                            .newBuilder()
                            .build();
                    return chain.proceed(request);
                }
            };

            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .build();

            return new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
                    .client(okHttpClient)
                    .build();
        }
        public static Observable<Forecast> create(Integer latitude, Integer longitude, String appId){
            Retrofit retrofit = create();
            ForecastService service = retrofit.create(ForecastService.class);
            return service.performCall(latitude, longitude, appId);
        }
    }

    // 2. Define the interface for the http request:
    // http://api.openweathermap.org/data/2.5/weather?lat=35&lon=139&id=7778677&appid=5ad7218f2e11df834b0eaf3a33a39d2a

    public interface ForecastService{


        @GET("data/2.5/weather?")
        Observable<Forecast> performCall(@Query("lat") Integer latitude, @Query("lon") Integer longitude, @Query("appid") String appId);

    }
}