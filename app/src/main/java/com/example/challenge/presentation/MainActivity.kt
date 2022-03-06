package com.example.challenge.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.challenge.databinding.ActivityMainBinding
import com.example.challenge.domain.model.Items

class MainActivity : AppCompatActivity(),RecyclerAdapter.MyViewHolder.OnClickListener {
    lateinit var itemsList: RecyclerView
    lateinit var itemsAdapter: RecyclerAdapter
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initItemList()
    }
    private fun initItemList(){
        itemsList = binding.itemsList
        itemsAdapter = RecyclerAdapter(this,this)
        itemsList.adapter = itemsAdapter
        itemsList.setHasFixedSize(true)
        itemsList.layoutManager = LinearLayoutManager(this)
    }

    override fun onItemClicked(item: Items) {
        if (!item.locked){
            val intent = Intent(this, ControlList::class.java)
            intent.putExtra("item",item)
            startActivity(intent)
        }
    }
}