package com.example.lovecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import com.example.lovecalculator.databinding.ActivityMainBinding
import com.example.lovecalculator.model.LoveApi
import com.example.lovecalculator.model.LoveModel
import com.example.lovecalculator.model.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//https://love-calculator.p.rapidapi.com/getPercentage?sname=Pahlavi&fname=Anjelina
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =  supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController
    }
}