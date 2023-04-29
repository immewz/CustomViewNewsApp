package com.mewz.customviewnewsapp.network.responses

import com.google.gson.annotations.SerializedName
import com.mewz.customviewnewsapp.data.vos.NewsVO

data class GetAllNewsResponse(
    @SerializedName("code") val code: Int = 0,
    @SerializedName("message") val message: String = "",
    @SerializedName("data") val data: ArrayList<NewsVO>? = null
){
    fun isResponseOk() = (code == 200) && (data != null)
}
