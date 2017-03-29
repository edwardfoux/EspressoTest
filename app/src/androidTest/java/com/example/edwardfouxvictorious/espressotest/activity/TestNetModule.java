package com.example.edwardfouxvictorious.espressotest.activity;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

@Module
public class TestNetModule {

    private String baseUrl;
    private String jsonObject = "{\n" +
            "\t\"earthquakes\": [\n" +
            "\t\t{\n" +
            "\t\t\t\"datetime\": \"2011-03-11 04:46:23\",\n" +
            "\t\t\t\"depth\": 24.4,\n" +
            "\t\t\t\"lng\": 142.369,\n" +
            "\t\t\t\"src\": \"us\",\n" +
            "\t\t\t\"eqid\": \"c0001xgp\",\n" +
            "\t\t\t\"magnitude\": 8.8,\n" +
            "\t\t\t\"lat\": 38.322\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"datetime\": \"2012-04-11 06:38:37\",\n" +
            "\t\t\t\"depth\": 22.9,\n" +
            "\t\t\t\"lng\": 93.0632,\n" +
            "\t\t\t\"src\": \"us\",\n" +
            "\t\t\t\"eqid\": \"c000905e\",\n" +
            "\t\t\t\"magnitude\": 8.6,\n" +
            "\t\t\t\"lat\": 2.311\n" +
            "\t\t}\n" +
            "\t]\n" +
            "}";

    public TestNetModule(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit() {
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.interceptors().add(new MockInterceptor());

        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }

    private class MockInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Response response = chain.proceed(request);
            MediaType contentType = response.body().contentType();
            ResponseBody body = ResponseBody.create(contentType, jsonObject);
            return response.newBuilder().body(body).build();
        }
    }
}