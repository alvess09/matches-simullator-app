package com.alvesariel.matchessimullatorapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alvesariel.matchessimullatorapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    //criamos o binding
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //aqui dizemos que ele recebe activityDetailBinding concatenando com inflatelayout
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }
}
