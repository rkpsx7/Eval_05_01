package com.example.eval05_01.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface DAO {

    @Insert(onConflict = REPLACE)
    fun insertPerson(person: PersonEntity)

    @Query("select * from PersonTable")
    fun getPersonFromDB(): ArrayList<PersonEntity>
}