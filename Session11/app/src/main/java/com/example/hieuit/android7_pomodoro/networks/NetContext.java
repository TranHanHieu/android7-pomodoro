package com.example.hieuit.android7_pomodoro.networks;

import android.util.Log;

import com.example.hieuit.android7_pomodoro.networks.services.LoginService;
import com.example.hieuit.android7_pomodoro.settings.SharedPrefs;

import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Header;
import retrofit2.http.Headers;

/**
 * Created by Hieu It on 1/18/2017.
 */

public class NetContext {
    private static final String TAG = NetContext.class.toString();
    private Retrofit retrofit;

    public static final NetContext instance = new NetContext();

    private NetContext(){

        OkHttpClient client = new OkHttpClient
                .Builder()
                .addInterceptor(new HeaderInterceptor())
                .addInterceptor(new LoggerInterceptor())
                .build();//build rồi sẽ fix cứng.

        retrofit = new Retrofit.Builder()
                .baseUrl("http://a-task.herokuapp.com/api/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    class LoggerInterceptor implements Interceptor{

        @Override
        public Response intercept(Chain chain) throws IOException {
            //1 Get request
            Request request = chain.request();
            //2. process request(print out)
            Log.d(TAG, String.format("url  : %s",request.url()));

            RequestBody body= request.body();
            if (body!=null){
                Log.d(TAG, String.format("body : %s",body.toString()));
            }

            okhttp3.Headers headers = request.headers();
            if (headers!=null){
                Log.d(TAG, String.format("header : %s",headers));
            }
            //3. proceed
            Response response =  chain.proceed(request);
            //4. process response
            Log.d(TAG, String.format("response : %s",response.toString()));
            Log.d(TAG, String.format("response body : %s",getResponseString(response)));
            return response;
        }
    }

    public <T> T create(Class<T> classz){
        return retrofit.create(classz);
    }

    class HeaderInterceptor implements Interceptor{

        @Override
        public Response intercept(Chain chain) throws IOException {
            String token = SharedPrefs.getInstance().getAccessToken();

            if (token!=null) {
                Request request = chain.request()
                        .newBuilder()
                        .addHeader("Authorization", String.format("JWT %s", token))
                        .build();
                return chain.proceed(request);
            }
            return chain.proceed(chain.request());
        }
    }

    public LoginService createLoginService(){
        return retrofit.create(LoginService.class);
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }



    //getResponseString dùng debug
    private String getResponseString(okhttp3.Response response) {
        ResponseBody responseBody = response.body();
        BufferedSource source = responseBody.source();
        try {
            source.request(Long.MAX_VALUE); // Buffer the entire body.
        } catch (IOException e) {
            e.printStackTrace();
        }
        Buffer buffer = source.buffer();
        return buffer.clone().readString(Charset.forName("UTF-8"));
    }
}
