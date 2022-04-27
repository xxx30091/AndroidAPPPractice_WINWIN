package com.arthurtang.androidapppractice_winwin.data

import android.os.Parcelable
import com.squareup.moshi.Json
//import kotlinx.parcelize.Parcelize

import kotlinx.android.parcel.Parcelize

@Parcelize
data class ContentData(
    @Json(name = "title") var title: String? = "",
    @Json(name = "content") var content: String? = "",
    @Json(name = "user") var user: User? = null,
    @Json(name = "favoriteCount") var favoriteCount: Int? = 0,
    @Json(name = "likeCount") var likeCount: Int? = 0,
    @Json(name = "commentCount") var commentCount: Int? = 0,
    @Json(name = "unlockCount") var unlockCount: Int? = 0,
    @Json(name = "tags") var tags: List<String?> = listOf(),
    @Json(name = "type") var type: Int? = 0,
    @Json(name = "imageUrls") var imageUrls: List<String?> = listOf(),
    @Json(name = "creationDate") var creationDate: String? = ""
) : Parcelable
