package com.mewz.customviewnewsapp.network

import com.mewz.customviewnewsapp.network.responses.GetAllNewsResponse
import com.mewz.customviewnewsapp.utiles.GET_NEWS
import com.mewz.customviewnewsapp.utiles.PARAM_ACCESS_TOKEN
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface NewsApi {
    @FormUrlEncoded
    @POST(GET_NEWS)
    fun getAllNews(@Field(PARAM_ACCESS_TOKEN) accessToken: String)
    :io.reactivex.Observable<GetAllNewsResponse>
}