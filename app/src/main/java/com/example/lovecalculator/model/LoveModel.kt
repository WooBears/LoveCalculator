package com.example.lovecalculator.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
@Entity("love_table")
data class LoveModel(
    @PrimaryKey(autoGenerate = true)
    var id : Int? = null,
    var fname: String,
    var sname: String,
    val percentage: String,
    val result: String
) : Serializable{
    override fun toString(): String {
        return "$fname \n $sname \n $percentage \n $result \n\n"
    }
}