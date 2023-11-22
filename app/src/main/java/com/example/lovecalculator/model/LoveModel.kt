package com.example.lovecalculator.model

import java.io.Serializable
data class LoveModel(
    val fname: String,
    val sname: String,
    val percentage: String,
    val result: String
) : Serializable{
}