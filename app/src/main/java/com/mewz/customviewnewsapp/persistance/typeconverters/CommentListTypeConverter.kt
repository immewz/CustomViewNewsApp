package com.mewz.customviewnewsapp.persistance.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mewz.customviewnewsapp.data.vos.CommentVO

class CommentListTypeConverter {
    @TypeConverter
    fun toString(commentList: ArrayList<CommentVO>): String {
        return Gson().toJson(commentList)
    }

    @TypeConverter
    fun toCommentList(commentListJsonStr: String): ArrayList<CommentVO> {
        val commentListType = object : TypeToken<ArrayList<CommentVO>>() {}.type
        return Gson().fromJson(commentListJsonStr, commentListType)
    }
}