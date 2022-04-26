package com.arthurtang.androidapppractice_winwin.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.arthurtang.androidapppractice_winwin.data.ContentData
import com.arthurtang.androidapppractice_winwin.data.Data
import com.arthurtang.androidapppractice_winwin.databinding.ItemContent1Binding
import com.arthurtang.androidapppractice_winwin.databinding.ItemContent2Binding

class MainAdapter(
    private val content: ContentData?
//    private val content: Data?
): ListAdapter<ContentData, RecyclerView.ViewHolder>(DiffCallBack) {

//    val content: ContentData? = null

    class Content1ViewHolder(private var binding: ItemContent1Binding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(content: ContentData) {
            binding.content = content
        }
    }

    class Content2ViewHolder(private var binding: ItemContent2Binding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(content: ContentData) {
            binding.content = content
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ITEM_VIEW_TYPE_1 -> Content1ViewHolder(
                ItemContent1Binding.inflate(
                    LayoutInflater.from(parent.context), parent, false)
            )
            ITEM_VIEW_TYPE_2 -> Content2ViewHolder(
                ItemContent2Binding.inflate(
                    LayoutInflater.from(parent.context), parent, false)
            )
            else -> throw ClassCastException("Unknown viewType $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (holder) {
            is Content1ViewHolder -> {
                holder.bind(getItem(position) as ContentData)
            }
        }
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<ContentData>() {
        override fun areItemsTheSame(oldItem: ContentData, newItem: ContentData): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: ContentData, newItem: ContentData): Boolean {
            return oldItem == newItem
        }

        private const val ITEM_VIEW_TYPE_1 = 1
        private const val ITEM_VIEW_TYPE_2 = 2
    }

    override fun getItemViewType(position: Int): Int {

        return when (content?.type) {
            2 -> ITEM_VIEW_TYPE_1
            1 -> ITEM_VIEW_TYPE_2
            else -> throw ClassCastException("Unknown viewType: ${content?.type}")
        }
    }
}

//sealed class