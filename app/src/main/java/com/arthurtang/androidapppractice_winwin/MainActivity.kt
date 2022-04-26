package com.arthurtang.androidapppractice_winwin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.arthurtang.androidapppractice_winwin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var toolbar: androidx.appcompat.widget.Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        binding.toolbar.visibility = View.VISIBLE
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }
}