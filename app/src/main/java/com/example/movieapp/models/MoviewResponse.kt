package com.example.movieapp.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MoviewResponse(
    @SerializedName("results")
    val moview : List<Movie>

):Parcelable{
    constructor() : this(mutableListOf())
}
