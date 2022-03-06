package com.example.challenge.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.challenge.R
import com.example.challenge.databinding.ActivityControlListBinding
import com.example.challenge.domain.model.Items

class ControlList : AppCompatActivity() {
    private lateinit var binding: ActivityControlListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityControlListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val items = intent.getSerializableExtra("item") as Items
        binding.button.setOnClickListener {

        }
    }
}