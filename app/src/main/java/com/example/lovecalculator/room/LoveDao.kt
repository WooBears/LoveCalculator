package com.example.lovecalculator.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.lovecalculator.model.LoveModel

@Dao
interface LoveDao {
    @Query("SELECT * FROM 'love_table' ORDER BY fname")
    fun getAll(): List<LoveModel>
    @Insert
    fun insert(loveModel: LoveModel)
    @Update
    fun update(loveModel: LoveModel)
    @Delete
    fun delete(loveModel: LoveModel)
}