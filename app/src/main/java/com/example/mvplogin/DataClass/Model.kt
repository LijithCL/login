package com.example.mvplogin.DataClass

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


data class Model(

    val `data`: List<DataX>,
    val message: String,
    val statusCode: Int,
    val success: Boolean,
    val total: Int
)

@Entity(tableName = "Users_data_table")
data class DataX(
//    @ColumnInfo(name = "user_id")

//    var userId: Int,
    val cost: Int?,
    @PrimaryKey(autoGenerate =false)
    val lot_number: String,
    val lot_type: String?,
    val status: String?,
    val weight: Int?
)