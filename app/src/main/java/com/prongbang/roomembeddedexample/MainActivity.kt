package com.prongbang.roomembeddedexample

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.google.gson.GsonBuilder
import com.prongbang.roomembeddedexample.di.InjectorFactory
import com.prongbang.roomembeddedexample.viewmodel.PostViewModel
import com.prongbang.roomembeddedexample.vo.Post
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: PostViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        viewModel = ViewModelProviders.of(this, InjectorFactory.providePostViewModelFactory(this)).get(PostViewModel::class.java)

        getPost()

        fab.setOnClickListener {
            getPost()
        }
    }

    private fun getPost() {
        viewModel.getPost().observe(this, Observer<List<Post>> {
            val json = GsonBuilder().setPrettyPrinting().create().toJson(it)
            tvContent.text = json
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return when (item.itemId) {
            R.id.action_settings ->
                return true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
