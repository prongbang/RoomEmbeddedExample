package com.prongbang.roomembeddedexample.vo

import com.google.gson.annotations.SerializedName

data class Content(
        @SerializedName("cover")
        var cover: String = "",

        @SerializedName("images")
        // @TypeConverter
        var images: ArrayList<Image>?,

        @SerializedName("details")
        var details: String = ""
)