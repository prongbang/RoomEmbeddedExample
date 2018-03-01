package com.prongbang.roomembeddedexample.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context
import com.prongbang.roomembeddedexample.dao.PostDao
import com.prongbang.roomembeddedexample.db.converter.ImageListConverter
import com.prongbang.roomembeddedexample.db.converter.TelephoneListConverter
import com.prongbang.roomembeddedexample.vo.Post

/**
 * Created by mdev on 2/28/2018 AD.
 */
@Database(entities = [Post::class], version = 1)
@TypeConverters(value = [ImageListConverter::class, TelephoneListConverter::class])
abstract class AppDatabase : RoomDatabase() {

    abstract fun postDao(): PostDao

    companion object {

        private var INSTANCE: AppDatabase? = null
        private val LOCK_INMEM = Any()

        fun getInMemoryDatabase(context: Context): AppDatabase {
            if (INSTANCE == null) {
                synchronized(LOCK_INMEM) {
                    INSTANCE = Room.inMemoryDatabaseBuilder(context.applicationContext, AppDatabase::class.java)
                            .fallbackToDestructiveMigration()
                            .build()
                }
            }
            return INSTANCE!!
        }
    }

}