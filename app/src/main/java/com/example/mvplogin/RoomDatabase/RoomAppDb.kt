package com.example.mvplogin.RoomDatabase

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mvplogin.DataClass.DataX
import com.example.mvplogin.MainActivity2

@Database(entities = [DataX::class], version = 3)
abstract class RoomAppDb : RoomDatabase() {
    abstract fun registerDatabaseDao(): RegisterDatabaseDao

    companion object {
        val Db_Name="UserDB"
        var instace: RoomAppDb? = null
        fun getAppDatabase(context: MainActivity2): RoomAppDb? {
            if (instace == null) {
                instace = Room.databaseBuilder<RoomAppDb>(context.applicationContext, RoomAppDb::class.java, Db_Name)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instace
        }


    }
}