package com.example.recyclerviewanimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewanimation.adapter.DragDropAdapter
import com.example.recyclerviewanimation.adapter.RvAdapter
import com.example.recyclerviewanimation.databinding.ActivityMainBinding
import com.example.recyclerviewanimation.model.Model

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val rvAdapter by lazy { RvAdapter() }
    private val modelList: MutableList<Model> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)



        binding.rv.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = rvAdapter
        }
        uploadData()
    }

    private fun uploadData() {
        repeat(100) {
            modelList.add(Model("Sample $it"))
        }
        rvAdapter.modelList = modelList
    }
}