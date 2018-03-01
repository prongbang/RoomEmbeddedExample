package com.prongbang.roomembeddedexample.di

import android.content.Context
import com.prongbang.roomembeddedexample.db.AppDatabase
import com.prongbang.roomembeddedexample.repository.PostRepository
import com.prongbang.roomembeddedexample.utils.AppExecutors
import com.prongbang.roomembeddedexample.viewmodel.PostViewModelFactory

/**
 * Created by mdev on 2/28/2018 AD.
 */
object InjectorFactory {

    fun providePostRepository(context: Context): PostRepository {

        return PostRepository(AppDatabase.getInMemoryDatabase(context), AppExecutors())
    }

    fun providePostViewModelFactory(context: Context) : PostViewModelFactory {
        return PostViewModelFactory(providePostRepository(context))
    }

}