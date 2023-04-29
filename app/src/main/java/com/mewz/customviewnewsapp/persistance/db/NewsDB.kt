package com.mewz.customviewnewsapp.persistance.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mewz.customviewnewsapp.data.vos.NewsVO
import com.mewz.customviewnewsapp.persistance.daos.NewsDao

@Database(entities = [NewsVO::class], version = 1, exportSchema = false)
abstract class NewsDB: RoomDatabase() {
    companion object{
        val DB_NAME = "NewsApp"
        var dbInstance: NewsDB? = null

        fun getDBInstance(context: Context): NewsDB{
            when(dbInstance){
                null -> {
                    dbInstance = Room.databaseBuilder(context, NewsDB::class.java, DB_NAME)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }

            val i = dbInstance
            return i!!
        }
    }

    abstract fun newsDao(): NewsDao
}