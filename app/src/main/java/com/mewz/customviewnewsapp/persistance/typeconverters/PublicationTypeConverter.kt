package com.mewz.customviewnewsapp.persistance.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mewz.customviewnewsapp.data.vos.PublicationVO

class PublicationTypeConverter {
    @TypeConverter
    fun toString(publicationVO: PublicationVO): String {
        return Gson().toJson(publicationVO)
    }

    @TypeConverter
    fun toPublication(publicationJson: String): PublicationVO {
        val publicationType = object : TypeToken<PublicationVO>() {}.type
        return Gson().fromJson(publicationJson, publicationType)
    }
}