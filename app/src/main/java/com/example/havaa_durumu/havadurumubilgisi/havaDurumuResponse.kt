package com.example.havadurumuv10.havadurumubilgisi

import com.google.gson.annotations.SerializedName

data class havaDurumuResponse(
    @SerializedName("city")
    val city: String,
    @SerializedName("result")
    val result: List<Result>,
    @SerializedName("success")
    val success: Boolean
)
{
    data class Result(
        @SerializedName("date")
        val date: String,
        @SerializedName("day")
        val day: String,
        @SerializedName("degree")
        val degree: String,
        @SerializedName("description")
        val description: String,
        @SerializedName("humidity")
        val humidity: String,
        @SerializedName("icon")
        val icon: String,
        @SerializedName("max")
        val max: String,
        @SerializedName("min")
        val min: String,
        @SerializedName("night")
        val night: String,
        @SerializedName("status")
        val status: String
    )
    
}