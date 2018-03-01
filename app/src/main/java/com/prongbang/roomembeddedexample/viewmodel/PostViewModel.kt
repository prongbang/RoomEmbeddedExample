package com.prongbang.roomembeddedexample.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.prongbang.roomembeddedexample.repository.PostRepository
import com.prongbang.roomembeddedexample.vo.Post

/**
 * Created by mdev on 2/28/2018 AD.
 */
class PostViewModel(private val postRepository: PostRepository): ViewModel() {

    fun getPost() : LiveData<List<Post>> {

        return postRepository.getPost()
    }

    fun getPostById(id:Int) : LiveData<Post> {

        return postRepository.getPostById(id)
    }

}