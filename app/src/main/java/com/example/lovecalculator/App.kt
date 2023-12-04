package com.example.lovecalculator

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.lovecalculator.room.AppDatabase
import dagger.hilt.android.HiltAndroidApp
@HiltAndroidApp
class App: Application() { }