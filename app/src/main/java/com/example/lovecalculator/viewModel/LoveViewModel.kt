package com.example.lovecalculator.viewModel

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lovecalculator.Repository
import com.example.lovecalculator.model.LoveApi
import com.example.lovecalculator.model.LoveModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoveViewModel @Inject constructor (
    private val repository: Repository,
    private val sharedPreferences: SharedPreferences
): ViewModel(){
    fun getLiveData(firstName: String, secondName: String): LiveData<LoveModel>{
        return  repository.getData(firstName,secondName)
    }
    fun isShow():Boolean{
        return sharedPreferences.getBoolean(SHOWED_KEY, false)
    }
    fun onShowed()
    {
        sharedPreferences.edit().putBoolean(SHOWED_KEY,true).apply()
    }
    companion object
    {
        const val SHOWED_KEY = "showed.key"
    }
}