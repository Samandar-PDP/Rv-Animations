package com.example.recyclerviewanimation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewanimation.databinding.Item2Binding

class DragDropAdapter : RecyclerView.Adapter<DragDropAdapter.DragDropViewHolder>() {
    var stringList = mutableListOf<String>()
//    private class DiffCallBack : DiffUtil.ItemCallback<String>() {
//        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
//            return oldItem.hashCode() == newItem.hashCode()
//        }
//
//        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
//            return oldItem == newItem
//        }
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DragDropViewHolder {
        return DragDropViewHolder(
            Item2Binding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return stringList.size
    }

    override fun onBindViewHolder(holder: DragDropViewHolder, position: Int) {
        holder.bind(stringList[position])
    }

    fun moveItem(from: Int, to: Int) {
        val currentList = stringList
        var fromLocation = currentList[from]
        if (to < from) {
            currentList.add(to + 1, fromLocation)
        } else {
            currentList.add(to - 1, fromLocation)
        }
        stringList = currentList
    }

    inner class DragDropViewHolder(private val binding: Item2Binding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(string: String) {
            binding.textView.text = string
        }
    }
}