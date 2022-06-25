package com.alvesariel.matchessimullatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alvesariel.matchessimullatorapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.tvHello.text = "teste"
    }
}