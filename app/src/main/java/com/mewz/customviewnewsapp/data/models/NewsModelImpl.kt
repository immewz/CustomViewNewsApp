package com.mewz.customviewnewsapp.data.models

import androidx.lifecycle.LiveData
import com.mewz.customviewnewsapp.data.vos.NewsVO
import com.mewz.customviewnewsapp.utiles.DUMMY_ACCESS_TOKEN
import com.mewz.customviewnewsapp.utiles.EM_NO_INTERNET_CONNECTION
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object NewsModelImpl: NewsModel, BaseModel() {
    override fun getAllNews(onError: (String) -> Unit): LiveData<List<NewsVO>> {
        return mTheDB.newsDao()
            .getAllNews()
    }

    override fun getAllNewsFromApiAndSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        mNewApi.getAllNews(DUMMY_ACCESS_TOKEN)
            .map { it.data?.toList() ?: listOf() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mTheDB.newsDao().insertAllNews(it)
            },{
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })
    }

    override fun getNewsById(newsId: Int): LiveData<NewsVO> {
        return mTheDB.newsDao().getNewsById(newsId)
    }
}