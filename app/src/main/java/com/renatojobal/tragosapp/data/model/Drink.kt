package com.renatojobal.tragosapp.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Drink(
    @SerializedName("strDrinkThumb")
    val image: String = "",
    @SerializedName("strDrink")
    val nombre: String = "",
    @SerializedName("strInstructions")
    val descripcion: String = ""
) : Parcelable


data class DrinkList(
    @SerializedName("drinks")
    val drinkList: List<Drink>)