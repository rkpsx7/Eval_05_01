package com.example.eval05_01.viewmodel

import androidx.lifecycle.ViewModel
import com.example.eval05_01.local.PersonEntity
import com.example.eval05_01.repositary.Repo

class ActorViewModel(val repo: Repo) : ViewModel() {

    fun getPersonFromDB(): ArrayList<PersonEntity> {
        return repo.getPersonFromDB()
    }
}