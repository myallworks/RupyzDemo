package dev.shrishri1108.Rupyz.Network

import dev.shrishri1108.Rupyz.Model.ListResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ListReciever {

    companion object {


        val retrofit = Retrofit
            .Builder()
            .baseUrl("http://devdeployed.rupyz.com:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val networkInterface: NetworkInterface by lazy {
            retrofit.create(NetworkInterface::class.java)
        }
    }


    init {

    }

    suspend fun getUsers(): ListResponse {
        return networkInterface.getUsers()
    }
}