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

//        val mock = listOf(
//            ContentData(
//                title = "AAA",
//                content = "AAAAAAAAAAAAAAAAAAAAAAA",
//                user = User(nickName = "a", imageUrl = ""),
//                favoriteCount = 111,
//                likeCount = 112,
//                commentCount = 113,
//                unlockCount = 114,
//                tags = listOf("A", "a", "Aa"),
//                type = 1,
//                imageUrls = listOf("","",""),
//                creationDate = "2022.01.01"
//            ),
//            ContentData(
//                title = "BBB",
//                content = "BBBBBBBBBBBBBBBBBBBBBBB",
//                user = User(nickName = "b", imageUrl = ""),
//                favoriteCount = 221,
//                likeCount = 222,
//                commentCount = 223,
//                unlockCount = 224,
//                tags = listOf("B", "b", "Bb"),
//                type = 2,
//                imageUrls = listOf("","",""),
//                creationDate = "2022.02.02"
//            ),
//            ContentData(
//                title = "CCC",
//                content = "CCCCCCCCCCCCCCCCCCCCCCC",
//                user = User(nickName = "c", imageUrl = ""),
//                favoriteCount = 331,
//                likeCount = 332,
//                commentCount = 333,
//                unlockCount = 334,
//                tags = listOf("C", "c"),
//                type = 1,
//                imageUrls = listOf("","",""),
//                creationDate = "2022.01.01"
//            )
//        )
//
//        adapter.submitList(mock)


        return binding.root
    }
}