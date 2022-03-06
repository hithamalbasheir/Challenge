package com.example.challenge.presentation

import android.content.ClipData
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.challenge.databinding.ListRowBinding
import com.example.challenge.domain.model.Items


class RecyclerAdapter(private val context: Context,private val onClickListener: MyViewHolder.OnClickListener) : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {
    private var itemsList = mutableListOf<Items>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ListRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.item.text = itemsList[position].itemNum
        var locked = itemsList[position].locked
        holder.locked.text = if(locked) "Locked" else "Unlocked"
        if(!locked) holder.lockedImage.visibility = View.INVISIBLE
        holder.itemView.setOnClickListener{onClickListener.onItemClicked(item= itemsList[position])}
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }

    fun setList(itemsList: MutableList<Items>) {
        this.itemsList = itemsList
        notifyDataSetChanged()
    }

    class MyViewHolder(private val binding: ListRowBinding):RecyclerView.ViewHolder(binding.root){
        val item = binding.itemTV
        val locked = binding.status
        val lockedImage = binding.image
        interface OnClickListener{
            fun onItemClicked(item: Items)
        }
    }
}