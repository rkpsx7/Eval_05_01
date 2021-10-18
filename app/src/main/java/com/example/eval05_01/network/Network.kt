package com.example.eval05_01.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Network {
    companion object {
        private fun getInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl("https://api.tvmaze.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        fun getRetrofitInstance() = getInstance().create(ApiService::class.java)
    }


}