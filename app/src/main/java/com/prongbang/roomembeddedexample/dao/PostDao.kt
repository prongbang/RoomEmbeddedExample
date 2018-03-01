package com.prongbang.roomembeddedexample.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import android.arch.persistence.room.Transaction
import com.prongbang.roomembeddedexample.vo.Post

/**
 * Created by mdev on 2/28/2018 AD.
 */
@Dao
abstract class PostDao : BaseDao<Post>() {

    @Transaction
    @Query("SELECT * FROM post")
    abstract fun findAll(): LiveData<List<Post>>

    @Transaction
    @Query("SELECT * FROM post WHERE id = :id")
    abstract fun findById(id: Int): LiveData<Post>

}