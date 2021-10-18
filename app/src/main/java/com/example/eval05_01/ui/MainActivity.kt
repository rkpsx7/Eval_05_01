package com.example.eval05_01.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.eval05_01.R
import com.example.eval05_01.local.MainRoomDB
import com.example.eval05_01.repositary.Repo

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val roomDB = MainRoomDB.getMainRoomDB(this)
        val dao = roomDB.getDao()
        val repo = Repo(dao)

    }
}