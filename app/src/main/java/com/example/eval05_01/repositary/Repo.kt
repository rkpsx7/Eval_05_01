package com.example.eval05_01.repositary

import androidx.lifecycle.LiveData
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
            for (i in 0 until response.size) {
                val item = response[i]
                var img = item.image?.medium
                var country = item.country?.name
                var dob = item.birthday
                var dod = item.deathday

                if (img == null)
                    img = ""
                if (country == null)
                    country = ""
                if (dob == null)
                    dob = ""
                if (dod == null)
                    dod = ""

                val person = PersonEntity(img, country, dob, dod)
                dao.insertPerson(person)
            }
        }

    }

    fun getPersonFromDB(): LiveData<List<PersonEntity>> {
        return dao.getPersonFromDB()
    }
}