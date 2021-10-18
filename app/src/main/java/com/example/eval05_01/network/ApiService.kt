package com.example.eval05_01.network

import com.example.eval05_01.model.ResposeDTO
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET
    fun getActors(): Call<ResposeDTO>

}