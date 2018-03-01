package com.prongbang.roomembeddedexample.repository

import android.arch.lifecycle.LiveData
import com.google.gson.Gson
import com.prongbang.roomembeddedexample.db.AppDatabase
import com.prongbang.roomembeddedexample.utils.AppExecutors
import com.prongbang.roomembeddedexample.vo.Post

/**
 * Created by mdev on 2/28/2018 AD.
 */
class PostRepository(private val appDatabase: AppDatabase, private val appExecutors: AppExecutors) {

    fun getPost(): LiveData<List<Post>> {

        appExecutors.diskIO().execute {

            val json = "{\n" +
                    "  \"id\": 1,\n" +
                    "  \"title\": \"Hello room embedded\",\n" +
                    "  \"content\": {\n" +
                    "    \"details\": \"Hello room embedded details...\",\n" +
                    "    \"cover\": \"http://127.0.0.1/api/v1/image/cover.jpg\",\n" +
                    "    \"images\": [\n" +
                    "      {\n" +
                    "        \"id\": 1,\n" +
                    "        \"url\": \"http://127.0.0.1/api/v1/image/image-1.jpg\",\n" +
                    "        \"description\": \"Description 1\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"id\": 3,\n" +
                    "        \"url\": \"http://127.0.0.1/api/v1/image/image-2.jpg\",\n" +
                    "        \"description\": \"Description 2\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"id\": 4,\n" +
                    "        \"url\": \"http://127.0.0.1/api/v1/image/image-3.jpg\",\n" +
                    "        \"description\": \"Description 3\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"id\": 5,\n" +
                    "        \"url\": \"http://127.0.0.1/api/v1/image/image-4.jpg\",\n" +
                    "        \"description\": \"Description 4\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"id\": 6,\n" +
                    "        \"url\": \"http://127.0.0.1/api/v1/image/image-5.jpg\",\n" +
                    "        \"description\": \"Description 5\"\n" +
                    "      }\n" +
                    "    ]\n" +
                    "  },\n" +
                    "  \"telephone\": [\n" +
                    "    {\n" +
                    "      \"icon\": \"http://127.0.0.1/api/v1/image/call-1.png\",\n" +
                    "      \"number\": \"087-234-6754\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"icon\": \"http://127.0.0.1/api/v1/image/call-3.png\",\n" +
                    "      \"number\": \"083-234-6759\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"icon\": \"http://127.0.0.1/api/v1/image/call-3.png\",\n" +
                    "      \"number\": \"085-234-6757\"\n" +
                    "    }\n" +
                    "  ]\n" +
                    "}"

            val post = Gson().fromJson<Post>(json, Post::class.java)
            appDatabase.postDao().insert(post)

        }

        return appDatabase.postDao().findAll()
    }

    fun getPostById(id: Int): LiveData<Post> {

        return appDatabase.postDao().findById(id)
    }

}