package com.example.eval05_01.repositary

import com.example.eval05_01.local.DAO
import com.example.eval05_01.local.PersonEntity
import com.example.eval05_01.network.Network

class Repo(val dao: DAO) {

    val apiService = Network.getRetrofitInstance()

    fun getPeronFromServer() {
        val response = apiService.getActors()
        for (i in 0..response.size) {
            val item = response[i]
            val img = item.image?.medium!!
            val country = item.country?.name!!
            val dob = item.birthday!!
            val dod = item.deathday!!

            val person = PersonEntity(img, country, dob, dod)

            dao.insertPerson(person)
        }
    }

    fun getPersonFromDB(): ArrayList<PersonEntity> {
        return dao.getPersonFromDB()
    }
}