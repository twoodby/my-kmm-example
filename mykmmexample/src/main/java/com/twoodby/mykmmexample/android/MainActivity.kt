package com.twoodby.mykmmexample.android

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide

//fun greet(): String {
//    return Greeting().greeting()
//}

class MainActivity : AppCompatActivity(R.layout.activity_main) {


    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.comic.observe(this) {
            when (it) {
                is State.Loading -> {
                    findViewById<TextView>(R.id.titleLabel)?.text = "Loading"
                }
                is State.Success -> {
                    findViewById<TextView>(R.id.titleLabel)?.text = it.result.title
                    Glide.with(this)
                        .load(it.result.imageUrl)
                        .into(findViewById(R.id.image))
                }
                is State.Error -> {
                    findViewById<TextView>(R.id.titleLabel)?.text = "Error"
                }
            }
        }
        viewModel.fetchComic()
    }

}
