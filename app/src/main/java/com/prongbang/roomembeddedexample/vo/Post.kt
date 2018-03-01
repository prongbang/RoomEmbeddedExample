package com.prongbang.roomembeddedexample.vo

import android.arch.persistence.room.*
import com.google.gson.annotations.SerializedName

@Entity(tableName = "post")
data class Post(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id")
        var id: Int,

        @SerializedName("title")
        @ColumnInfo(name = "title")
        var title: String = "",

        @SerializedName("content")
        @Embedded(prefix = "content_")
        var content: Content,

        @SerializedName("telephone")
        @ColumnInfo(name = "telephone")
        var telephone: ArrayList<Telephone>?
)
