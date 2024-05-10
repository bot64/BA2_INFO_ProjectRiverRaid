package com.example.ba2_info_projectriverraid.map

import com.example.ba2_info_projectriverraid.utils.DifficultyAndData
import com.example.ba2_info_projectriverraid.entities.Entities


    class Map(
    var xmin :Float = 0f,
    var xmax :Float = 0f,
    var ymin :Float = 0f,
    var ymax :Float = 0f
)
    {
    init {

    }

    fun isOutOfBounds(X : Float,Y : Float): Boolean {
        return X <= xmin || Y <= xmin || X >= xmax  || Y >= ymax
    }


    }

















