package com.example.earthquakes.models
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Metadata(
    val count: Int,
    val title: String,
    val status: Int
) : Parcelable