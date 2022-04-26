package com.arthurtang.androidapppractice_winwin.data

import com.squareup.moshi.Json

data class Data(
    @Json(name = "") var data: List<ContentData?> = listOf(),
//    @Json(name = "") var data: ArrayList<ContentData?> = arrayListOf(),
)
