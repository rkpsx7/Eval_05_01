package com.example.eval05_01.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.eval05_01.local.PersonEntity
import com.example.eval05_01.repositary.Repo

class ActorViewModel(private val repo: Repo) : ViewModel() {

    fun getPersonFromDB(): LiveData<List<PersonEntity>> {
        return repo.getPersonFromDB()
    }

    fun getDataFromServer() {
        repo.getPeronFromServer()
    }
}