package com.example.eval05_01.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "PersonTable")
data class PersonEntity(
    @ColumnInfo(name = "img_url") var img_url: String,
    @ColumnInfo(name = "country") var country: String,
    @ColumnInfo(name = "dob") var dob: String,
    @ColumnInfo(name = "dod") var dod: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null
}