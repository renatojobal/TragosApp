package com.renatojobal.tragosapp.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class Drink(
    @PrimaryKey
    @SerializedName("idDrink")
    val tragoId: String = "",
    @ColumnInfo(name="trago_imagen")
    @SerializedName("strDrinkThumb")
    val image: String = "",
    @ColumnInfo(name="trago_nombre")
    @SerializedName("strDrink")
    val nombre: String = "",
    @ColumnInfo(name="trago_descripcion")
    @SerializedName("strInstructions")
    val descripcion: String = "",
    @ColumnInfo(name="trago_has_alcohol")
    @SerializedName("strAlcoholic")
    val hasAlcohol : String = "Non_Alcoholic"
) : Parcelable


data class DrinkList(
    @SerializedName("drinks")
    val drinkList: List<Drink>)


