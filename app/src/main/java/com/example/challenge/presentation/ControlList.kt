package com.example.challenge.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.challenge.R
import com.example.challenge.data.DatabaseModule
import com.example.challenge.data.ItemsDAO
import com.example.challenge.databinding.ActivityControlListBinding
import com.example.challenge.domain.model.Items
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ControlList : AppCompatActivity() {
    private lateinit var binding: ActivityControlListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityControlListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val items = intent.getSerializableExtra("item") as Items
         binding.checkBox2.isChecked
        if (binding.checkBox3.isChecked) binding.button.isEnabled = true
        if (binding.checkBox4.isChecked) binding.button.isEnabled = true
        if (binding.checkBox5.isChecked) binding.button.isEnabled = true
        binding.button.setOnClickListener {
            binding.button.isEnabled = false
            val itemsDao = DatabaseModule.getInstance(application).itemsDao()
            CoroutineScope(Dispatchers.IO).launch{
                itemsDao.unlockItem()
            }

        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}