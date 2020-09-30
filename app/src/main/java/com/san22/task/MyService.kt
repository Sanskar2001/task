package com.san22.task

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface MyService {
    @Headers("Content-Type:application/json")
    @FormUrlEncoded
    @POST("/machine-task/login.php")
    fun senddatatoLoginApi(@Field("email")email:String,@Field("password")password: String): Call<ResponseBody>
    @POST("/machine-task/register.php")
     fun senddatatoRegisterApi(@Field("name")name:String,
                               @Field("email") email:String,
                               @Field("number")number:String,
                               @Field("password")password:String):Call<ResponseBody>
}