package com.example.mvplogin.RoomDatabase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

import com.example.mvplogin.DataClass.DataX

@Dao
interface RegisterDatabaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(register: MutableList<DataX>)

    @Query("SELECT * FROM users_data_table")
    fun getAllUser(): List<DataX>

    @Query("DELETE FROM Users_data_table")
    fun deleteAll()



}