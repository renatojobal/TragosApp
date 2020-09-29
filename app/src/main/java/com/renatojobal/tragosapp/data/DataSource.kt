package com.renatojobal.tragosapp.data

import com.renatojobal.tragosapp.data.model.Drink
import com.renatojobal.tragosapp.vo.Resource

class DataSource {

    val generateTragosList = Resource.Success(listOf(
        Drink("https://cdn5.recetasdeescandalo.com/wp-content/uploads/2018/09/Coctel-margarita-como-prepararlo.-Receta-e-ingredientes.jpg", "Margarta", "Con azucar, vocdka y nueces"),
        Drink("https://www.recetas-argentinas.com/base/stock/Recipe/2-image/2-image_web.jpg", "Fernet", "Fernet con coca y 2 hielos"),
        Drink("https://i.pinimg.com/originals/ea/0e/c4/ea0ec408ada16d644753129050418687.jpg", "Toro", "Toro con pritty"),
        Drink("https://64.media.tumblr.com/2a00c67fe2becf9e6704245c2432e625/tumblr_ny82d7tHAT1u916tro1_640.jpg", "Gancia", "Gancia con sprite")
    ))



}