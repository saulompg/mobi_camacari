package com.icti.mobi_camacari.data.api


import com.icti.mobi_camacari.data.classes.UsersItem
import retrofit2.Call
import retrofit2.http.GET

interface Endpoint {
    @GET("usuarios")
    fun getUsers() : Call<List<UsersItem>>
}