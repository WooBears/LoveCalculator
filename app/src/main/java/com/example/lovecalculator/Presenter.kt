package com.example.lovecalculator

import com.example.lovecalculator.model.LoveApi
import com.example.lovecalculator.model.LoveModel
import com.example.lovecalculator.model.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Presenter(private val loveView: LoveView) {

    val api = RetrofitService.api

    fun getLove(firstName: String, secondName: String){
        api.getLove(firstName, secondName).enqueue(object :Callback<LoveModel>{
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                loveView.showRespond(response.body().toString())
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                loveView.showError(t.message.toString())
            }
        })
    }
}