package com.example.lovecalculator.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.lovecalculator.Repository
import com.example.lovecalculator.model.LoveModel

class LoveViewModel: ViewModel(){

    val repository = Repository()

    fun getLiveData(firstName: String, secondName: String): LiveData<LoveModel>{
        return repository.getData(firstName,secondName)
    }
}