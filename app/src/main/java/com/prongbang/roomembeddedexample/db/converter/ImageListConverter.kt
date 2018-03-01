package com.prongbang.roomembeddedexample.db.converter

import android.arch.persistence.room.TypeConverter
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.prongbang.roomembeddedexample.vo.Image
import java.lang.reflect.ParameterizedType

/**
 * Created by mdev on 2/28/2018 AD.
 */
class ImageListConverter : BaseListConverter<Image>() {

    @TypeConverter
    override fun fromString(value: String): ArrayList<Image> {
        val typeToken = object : TypeToken<ArrayList<Image>>() {}
        val type = typeToken.type as ParameterizedType
        val list = GsonBuilder().create().fromJson<ArrayList<Image>>(value, type)
        return list ?: ArrayList()
    }

}