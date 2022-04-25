package com.arthurtang.androidapppractice_winwin.main

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.arthurtang.androidapppractice_winwin.data.ContentData
import com.arthurtang.androidapppractice_winwin.databinding.ItemContent1Binding
import com.arthurtang.androidapppractice_winwin.databinding.ItemContent2Binding

class MainAdapter(): ListAdapter<ContentData, RecyclerView.ViewHolder>(DiffCallBack) {

    class Content1ViewHolder(private var binding: ItemContent1Binding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
        }
    }

    class Content2ViewHolder(private var binding: ItemContent2Binding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<ContentData>() {
        override fun areItemsTheSame(oldItem: ContentData, newItem: ContentData): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: ContentData, newItem: ContentData): Boolean {
            return oldItem == newItem
        }

    }
}