package com.example.eval05_01.repositary

import com.example.eval05_01.local.DAO
import com.example.eval05_01.local.PersonEntity
import com.example.eval05_01.network.Network
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class Repo(val dao: DAO) {

    val apiService = Network.getRetrofitInstance()

    fun getPeronFromServer() {
        CoroutineScope(IO).launch {
            val response = apiService.getActors()
            for (i in 0..response.size) {
                if (response[i] != null) {
                    val item = response[i]
                    var img = item.image?.medium
                    var country = item.country?.name
                    var dob = item.birthday
                    var dod = item.deathday

                    if (img == null || country == null || dob == null || dod == null) {
                        country = ""
                        dob = ""
                        dod = ""
                        img = ""
                    }
                    val person = PersonEntity(img, country, dob, dod)
                    dao.insertPerson(person)
                }




            }
        }

    }

    fun getPersonFromDB(): List<PersonEntity> {
        getPeronFromServer()
        return dao.getPersonFromDB()
    }
}