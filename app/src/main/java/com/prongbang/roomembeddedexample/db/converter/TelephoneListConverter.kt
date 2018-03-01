package com.prongbang.roomembeddedexample.db.converter

import android.arch.persistence.room.TypeConverter
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.prongbang.roomembeddedexample.vo.Telephone
import java.lang.reflect.ParameterizedType

/**
 * Created by mdev on 3/1/2018 AD.
 */
class TelephoneListConverter: BaseListConverter<Telephone>() {

    @TypeConverter
    override fun fromString(value: String): ArrayList<Telephone> {
        val typeToken = object : TypeToken<ArrayList<Telephone>>() {}
        val type = typeToken.type as ParameterizedType
        val list = GsonBuilder().create().fromJson<ArrayList<Telephone>>(value, type)
        return list ?: ArrayList()
    }

}