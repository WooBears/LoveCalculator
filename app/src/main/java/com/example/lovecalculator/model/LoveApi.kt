package com.example.lovecalculator.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {
    @GET("getPercentage")
    fun getLove(
        @Query("sname") secondName: String,
        @Query("fname") firstName: String,
        @Header("X-RapidAPI-Key") key: String = "3e594b6565msh8ef2a36fdf0108dp113257jsn441a90df4099",
        @Header("X-RapidAPI-Host") host: String = "love-calculator.p.rapidapi.com") : Call<LoveModel>
}