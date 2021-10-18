package com.example.eval05_01.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.eval05_01.R
import com.example.eval05_01.local.MainRoomDB
import com.example.eval05_01.local.PersonEntity
import com.example.eval05_01.repositary.Repo
import com.example.eval05_01.viewmodel.ActorViewModel
import com.example.eval05_01.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var adapter: Adapter? = null
    private var persons = ArrayList<PersonEntity>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val roomDB = MainRoomDB.getMainRoomDB(this)
        val dao = roomDB.getDao()
        val repo = Repo(dao)
        val factory = ViewModelFactory(repo)
        val viewModel = ViewModelProviders.of(this, factory).get(ActorViewModel::class.java)

        viewModel.getDataFromServer()

        viewModel.getPersonFromDB().observe(this, {
            if (it != null) {
                persons = it as ArrayList<PersonEntity>
            }
            setAdapter()
            //adapter?.notifyDataSetChanged()
        })


    }

    private fun setAdapter() {
        adapter = Adapter(persons)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}
