package com.mewz.customviewnewsapp.data.models

import android.content.Context
import com.mewz.customviewnewsapp.network.NewsApi
import com.mewz.customviewnewsapp.persistance.db.NewsDB
import com.mewz.customviewnewsapp.utiles.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

abstract class BaseModel {

    protected var mNewApi: NewsApi
    protected lateinit var mTheDB: NewsDB

    init {
        val mOkHttpClient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(mOkHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        mNewApi = retrofit.create(NewsApi::class.java)
    }

    fun initDatabase(context: Context){
        mTheDB = NewsDB.getDBInstance(context)
    }
}