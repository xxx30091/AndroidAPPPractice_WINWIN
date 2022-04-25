package com.arthurtang.androidapppractice_winwin.data

data class ContentData(
    var title: String? = "",
    var content: String? = "",
    var user: User? = User(),
    var favoriteCount: Int? = 0,
    var likeCount: Int? = 0,
    var commentCount: Int? = 0,
    var unlockCount: Int? = 0,
    var tags: ArrayList<String> = arrayListOf(),
    var type: Int? = 0,
    var imageUrls: ArrayList<String> = arrayListOf(),
    var creationDate: String? = ""
)
