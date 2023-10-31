package com.icti.mobi_camacari.data.api

import android.util.Log
import com.icti.mobi_camacari.data.classes.UsersItem
import com.icti.mobi_camacari.data.util.NetworkUtils
import retrofit2.Call
import retrofit2.Response

class Api {

    fun getUsers() {
        val retrofitClient = NetworkUtils.getRetroFitInstance(BASE_URL)
        val endpoint = retrofitClient.create(Endpoint::class.java)

        endpoint.getUsers().enqueue(
            object : retrofit2.Callback<List<UsersItem>> {
                override fun onResponse(
                    call: Call<List<UsersItem>>,
                    response: Response<List<UsersItem>>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.let {
                            for (user in it) {
                                Log.i("retrofit", "onResponse: ${user.nome}")
                            }
                        }
                    }
                }

                override fun onFailure(
                    call: Call<List<UsersItem>>,
                    t: Throwable
                ) {
                    Log.d("retrofit", "erro ao consultar api")
                }
            }
        )

    }

    companion object {
        private const val BASE_URL = "https://springboot-api-production-bf41.up.railway.app/"
    }

}