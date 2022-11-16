package com.example.recyclerviewanimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewanimation.adapter.DragDropAdapter
import com.example.recyclerviewanimation.adapter.itemTouchHelper
import com.example.recyclerviewanimation.databinding.ActivityDragDropBinding
import com.example.recyclerviewanimation.model.Model

class DragDropActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDragDropBinding
    private val stringList = mutableListOf<String>()
    private val dragDropAdapter by lazy { DragDropAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDragDropBinding.inflate(layoutInflater)
        setContentView(binding.root)

        itemTouchHelper.attachToRecyclerView(binding.rv)

        binding.rv.apply {
            adapter = dragDropAdapter
            layoutManager = LinearLayoutManager(this@DragDropActivity)
        }
        uploadData()
    }
    private fun uploadData() {
        repeat(100) {
            stringList.add("Item $it")
        }
        dragDropAdapter.stringList = stringList
    }
}