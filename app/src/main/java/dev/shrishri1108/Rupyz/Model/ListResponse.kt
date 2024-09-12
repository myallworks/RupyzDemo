package dev.shrishri1108.Rupyz.Model

import com.google.gson.annotations.SerializedName

data class ListResponse(
    @SerializedName("data")
    val data: ArrayList<Data>,
    @SerializedName("message")
    val message: String,
    @SerializedName("error")
    val error: Boolean
)