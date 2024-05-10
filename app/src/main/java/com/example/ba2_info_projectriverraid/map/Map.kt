package com.example.ba2_info_projectriverraid.map


    class Map(
    var xmin :Float = 0f,
    var xmax :Float = 0f,
    var ymin :Float = 0f,
    var ymax :Float = 0f
)
    {
    fun isOutOfBounds(X : Float,Y : Float): Boolean {
        return X <= xmin || Y <= ymin || X >= xmax  || Y >= ymax
    }
    }

















