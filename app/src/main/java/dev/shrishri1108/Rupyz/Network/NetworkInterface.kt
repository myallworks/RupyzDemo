package dev.shrishri1108.Rupyz.Network

import dev.shrishri1108.Rupyz.Model.ContentResponse
import dev.shrishri1108.Rupyz.Model.ListResponse
import retrofit2.http.GET

interface NetworkInterface {

    @GET("v1/blog/public/?page_no=1")
    suspend fun getUsers(): ListResponse

    @GET("v1/blog/public/?slug_str")
    suspend fun getContent(): ContentResponse
}