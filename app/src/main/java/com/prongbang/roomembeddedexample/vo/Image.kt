package com.prongbang.roomembeddedexample.vo

import com.google.gson.annotations.SerializedName

data class Image(
        @SerializedName("description")
        var description: String = "description",

        @SerializedName("id")
        var id: Int = 0,

        @SerializedName("url")
        var url: String = ""
)