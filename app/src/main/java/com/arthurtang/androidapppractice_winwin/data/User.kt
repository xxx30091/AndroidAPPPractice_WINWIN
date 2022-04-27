package com.arthurtang.androidapppractice_winwin.data

import android.os.Parcelable
import com.squareup.moshi.Json
//import kotlinx.parcelize.Parcelize
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    @Json(name = "nickName") var nickName: String? = "",
    @Json(name = "imageUrl") var imageUrl: String? = ""
) : Parcelable
