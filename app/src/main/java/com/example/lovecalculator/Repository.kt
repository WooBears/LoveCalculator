package com.example.lovecalculator

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lovecalculator.model.LoveApi
import com.example.lovecalculator.model.LoveModel
import com.example.lovecalculator.model.RetrofitService
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


class Repository @Inject constructor(
    private val api: LoveApi
) {
    fun getData(firstName: String, secondName: String): MutableLiveData<LoveModel>{
        val love = MutableLiveData<LoveModel>()

        api.getLove(firstName,secondName).enqueue(object :Callback<LoveModel>{
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                if (response.isSuccessful){
                    response.body().let {
                        love.postValue(it)
                    }
                }
            }
            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                Log.e("ololo","onFailure: ${t.message }")
            }
        })
        return love
    }
}