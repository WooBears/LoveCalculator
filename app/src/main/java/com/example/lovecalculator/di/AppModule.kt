package com.example.lovecalculator.di

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.example.lovecalculator.model.LoveApi
import com.example.lovecalculator.room.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideApi(): LoveApi{
        return Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create()).build().create(LoveApi::class.java)
    }

    @Provides
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences{
        return context.getSharedPreferences("", Context.MODE_PRIVATE)
    }

    @Provides
    fun provideRoom(@ApplicationContext context: Context) : AppDatabase {
        return  Room.databaseBuilder(context, AppDatabase::class.java, "love-file").
        allowMainThreadQueries().
        build()
    }

}