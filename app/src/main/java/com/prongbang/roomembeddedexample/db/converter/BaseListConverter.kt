package com.prongbang.roomembeddedexample.db.converter

import android.arch.persistence.room.TypeConverter
import com.google.gson.*
import com.google.gson.reflect.TypeToken


/**
 * Created by mdev on 2/28/2018 AD.
 */
abstract class BaseListConverter<T> {

    @TypeConverter
    abstract fun fromString(value: String): ArrayList<T>

    /**
     * Bug: ClassCastException: com.google.gson.internal.LinkedTreeMap cannot be cast to ...
     */
//    @TypeConverter
//    fun fromString(value: String): ArrayList<T> {
//        val type = object : TypeToken<T>() {}.type
//        val list = ArrayList<T>()
//        if (value != "") {
//            try {
//                val gson = Gson()
//                val arrs = JsonParser().parse(value).asJsonArray
//                arrs?.mapTo(list) { gson.fromJson<T>(it, type) }
//            } catch (e: Exception) {
//                e.printStackTrace()
//            }
//        }
//        return list
//    }

    @TypeConverter
    fun fromArrayList(value: ArrayList<T>): String {
        val json = GsonBuilder().create().toJson(value)
        return json ?: ""
    }

}