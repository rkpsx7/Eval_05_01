package com.example.eval05_01.ui

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.eval05_01.R
import com.example.eval05_01.local.MainRoomDB
import com.example.eval05_01.local.PersonEntity
import com.example.eval05_01.repositary.Repo
import com.example.eval05_01.viewmodel.ActorViewModel
import com.example.eval05_01.viewmodel.ViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private var persons = ArrayList<PersonEntity>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btn = findViewById<Button>(R.id.btn_show)

        val roomDB = MainRoomDB.getMainRoomDB(this)
        val dao = roomDB.getDao()
        val repo = Repo(dao)
        val factory = ViewModelFactory(repo)
        val viewModel = ViewModelProviders.of(this, factory).get(ActorViewModel::class.java)

        CoroutineScope(IO).launch {
            persons = viewModel.getPersonFromDB() as ArrayList<PersonEntity>
        }

        btn.setOnClickListener {
            Log.d("rkpsx7", persons[0].toString())
        }


    }
}