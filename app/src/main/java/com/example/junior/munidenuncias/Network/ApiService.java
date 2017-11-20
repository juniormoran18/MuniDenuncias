package com.example.junior.munidenuncias.Network;

import com.example.junior.munidenuncias.Repository.Denuncia;
import com.example.junior.munidenuncias.Repository.User;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by Junior on 13/11/17.
 */

public interface ApiService {
    String API_BASE_URL = "https://muni-denuncias-juniormoran18.c9users.io";

    @GET("api/v1/denuncias")
    Call<List<Denuncia>> getDenuncias();

    @POST("api/v1/usuarios")
    Call<User> loginUser();

    @FormUrlEncoded
    @POST("/api/v1/denuncias")
    Call<ResponseMessage> createDenuncia(@Field("titulo") String titulo,
                                         @Field("descripcion") String descripcion,
                                         @Field("usuarios_id") String usuarios_id);
    @Multipart
    @POST("/api/v1/denuncias")
    Call<ResponseMessage> createDenunciaWithImage(
            @Part("titulo") RequestBody titulo,
            @Part("descripcion") RequestBody descripcion,

            @Part MultipartBody.Part imagen,
            @Part("usuarios_id") RequestBody usuarios_id
    );


}
