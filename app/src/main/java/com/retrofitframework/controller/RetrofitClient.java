package com.igniva.framework.controller;

import android.content.Context;

import com.igniva.framework.utils.Log;
import com.igniva.framework.utils.PreferenceHandler;
import com.jakewharton.retrofit.Ok3Client;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;


/**
 * Created by cl-macmini-38 on 18/05/16.
 */
public class RetrofitClient {

    private static final int CONNECT_TIMEOUT_MILLIS = 60 * 1000; // 60s
    private static final int READ_TIMEOUT_MILLIS = 30 * 1000; // 60s
    private static final int WRITE_TIMEOUT_MILLIS = 15 * 1000; // 60s
    private static RestAdapter adapter;


    private static OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
    static RestAdapter.Builder builder;
    private static final String LOG_TAG="RetrofitClient";

    private static RequestInterceptor newInterceptor(final Context context) {
        RequestInterceptor requestInterceptor = new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {
                String token = "ac";
                if (token != null) {
                    request.addHeader("x-logintoken", "eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI1OWQ0YmUyZDBiNDg3NjY0ZDc5ZTNiNDkiLCJmdWxsTmFtZSI6IkppdGVuZGVyIGRldiIsImVtYWlsIjoiaGltYW5zaHVAbWFpbGluYXRvci5jb20iLCJtb2JpbGVfbnVtYmVyIjoiOTAzNDQ4NTkwMSIsImlhdCI6MTUwNzExNzc2Nn0.EREhvLWWdrZ8wciDJeRK3FRK89Jugr372mbefIfnxBePDq2_J7ST0repM_LiaPROie_nW4_ZzlxD_l1Hk96rIQ");
                }
            }
        };
        return requestInterceptor;
    }

    static RestAdapter.Builder getBuilder(Context context) {
        if (builder == null) {
            builder = new RestAdapter.Builder()
                    .setEndpoint(Config.getBaseURL())
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .setRequestInterceptor(newInterceptor(context))
                    .setClient()
                    .setLog(new RestAdapter.Log() {
                        @Override
                        public void log(String message) {
                            Log.d(LOG_TAG, "Payload " + message);
//                            if (message.startsWith("{") || message.startsWith("[")) {
//                                Log.d(LOG_TAG, "Payload " + message);
//                                try {
//                                    if (flog.equals("abc")) ;
//                                } catch (Exception e) {
//                                    CrashReportingManager.logException(message);
//                                    FirebaseCrash.report(e);
//                                }
//                            }


                        }
                    });
        }
        return builder;
    }

    public static <S> S createService(Class<S> serviceClass, Context context) {
        getBuilder(context);
        okHttpClient.connectTimeout(CONNECT_TIMEOUT_MILLIS, TimeUnit.SECONDS);
        okHttpClient.readTimeout(READ_TIMEOUT_MILLIS, TimeUnit.SECONDS);
        okHttpClient.writeTimeout(WRITE_TIMEOUT_MILLIS, TimeUnit.SECONDS);

        builder.setClient(new Ok3Client(okHttpClient.build()));
        if (adapter == null)
            adapter = builder.build();
        return adapter.create(serviceClass);
    }

}

