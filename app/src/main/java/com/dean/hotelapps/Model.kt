package com.dean.hotelapps

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Model (
    var title: String,
    var address: String,
    var desc: String,
    var image: Int
) : Parcelable
