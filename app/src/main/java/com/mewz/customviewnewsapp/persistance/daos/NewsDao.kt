package com.mewz.customviewnewsapp.persistance.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mewz.customviewnewsapp.data.vos.NewsVO

@Dao
interface NewsDao {
    @Query("SELECT * FROM news")
    fun getAllNews(): LiveData<List<NewsVO>>

    @Query("SELECT * FROM news WHERE id = :noteId")
    fun getNewsById(noteId: Int): LiveData<NewsVO>

    @Query("DELETE FROM news")
    fun deleteALl()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNews(noteVO: NewsVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllNews(news: List<NewsVO>)

}