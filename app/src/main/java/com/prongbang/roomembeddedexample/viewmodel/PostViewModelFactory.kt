package com.prongbang.roomembeddedexample.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.prongbang.roomembeddedexample.repository.PostRepository

/**
 * Created by mdev on 2/28/2018 AD.
 */
class PostViewModelFactory(private val postRepository: PostRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        @Suppress("UNCHECKED_CAST")
        return PostViewModel(postRepository) as T
    }
}