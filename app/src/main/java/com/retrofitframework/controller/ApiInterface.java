package com.retrofitframework.controller;



import java.util.Map;

import okhttp3.ResponseBody;
import retrofit.Callback;
import retrofit.http.FieldMap;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Part;
import retrofit.http.Query;
import retrofit.mime.TypedFile;
import retrofit2.Call;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("/api/Manager/login")
    public void login(@FieldMap Map<String, String> params, Callback<ResponsePojo> callback);

    @FormUrlEncoded
    @Headers({
            "Content-type: application/json"
    })
    @POST("/users/login")
    void accessTokenLogin(@FieldMap Map<String, String> params, Callback<ResponsePojo> callback);

    @retrofit2.http.POST
    void profilePicture(@Url String url, @FieldMap Map<String, String> params, Callback<ResponsePojo> abc);

    @FormUrlEncoded
    @POST("/api/v1/posts/post")
    void getComment(@Query("page") String pageNumber,@FieldMap Map<String, String> params, Callback<ResponsePojo> callback);

    @FormUrlEncoded
    @POST("/v1/Admin/searchArticle")
    void article(@FieldMap Map<String, String> params, Callback<ResponsePojo> callback);

    @Multipart
    @PUT("/v1/Users/updateProfile")
    void updateProfile(
              @Part("fullName") String fullName
            , @Part("profilePic") TypedFile file
            , @Part("address") String address
            , @Part("state") String state
            , @Part("postcode") String postcode,
             Callback<ResponsePojo> callback);

    @GET("/resource/example.zip")
    Call<ResponsePojo> downloadFileWithDynamicUrlSync(@Url String fileUrl);

}
