package com.example.eval05_01.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [PersonEntity::class], version = 1)
abstract class MainRoomDB : RoomDatabase() {
    abstract fun getDao(): DAO


    companion object {
        private var Instance: MainRoomDB? = null

        fun getMainRoomDB(context: Context): MainRoomDB {
            if (Instance == null) {
                val builder = Room.databaseBuilder(
                    context.applicationContext,
                    MainRoomDB::class.java,
                    "PersonDB"
                )
                builder.fallbackToDestructiveMigration()
                Instance = builder.build()
            }
            return Instance!!
        }
    }
}