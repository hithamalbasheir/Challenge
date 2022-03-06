package com.example.challenge.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.challenge.data.DatabaseModule
import com.example.challenge.databinding.ActivityMainBinding
import com.example.challenge.domain.model.Items
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity(),RecyclerAdapter.MyViewHolder.OnClickListener {
    lateinit var itemsList: RecyclerView
    lateinit var itemsAdapter: RecyclerAdapter
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initItemList()
        fetchItemsFromDB()
    }
    private fun fetchItemsFromDB() {
        var itemsList = mutableListOf<Items>(
        Items(1,"item 1", false),
        Items(2,"item 2",true),
        Items(3,"item 3",true),
        Items(4,"item 4",true),
        Items(5,"item 5",true)
    )
        val itemsDao = DatabaseModule.getInstance(application).itemsDao()
        var data = mutableListOf<Items>()
        CoroutineScope(Dispatchers.IO).launch{
            data = itemsDao.getItems() as MutableList<Items>
            if(data.isEmpty()){
                data = itemsList
                itemsDao.insertNews(itemsList)
            }
            withContext(Dispatchers.Main){
                itemsAdapter.setList(data as MutableList<Items>)
            }
        }
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