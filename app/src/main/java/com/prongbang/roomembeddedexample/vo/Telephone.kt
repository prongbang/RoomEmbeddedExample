package com.prongbang.roomembeddedexample.vo

import com.google.gson.annotations.SerializedName

data class Telephone(
        @SerializedName("number")
        var number: String,
        @SerializedName("icon")
        var icon: String
)