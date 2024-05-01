package com.example.earthquakes.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Feature(
    val type: String,
    val properties: Properties,
    val geometry: Geometry
) : Parcelable


