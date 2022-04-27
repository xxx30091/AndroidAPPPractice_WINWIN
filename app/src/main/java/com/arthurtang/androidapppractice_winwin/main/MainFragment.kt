package com.arthurtang.androidapppractice_winwin.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.arthurtang.androidapppractice_winwin.data.ContentData
import com.arthurtang.androidapppractice_winwin.data.User
import com.arthurtang.androidapppractice_winwin.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentMainBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        val adapter = MainAdapter(viewModel.content.value)
        binding.rvMainPage.adapter = adapter

        viewModel.contentData.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        return binding.root
    }
}