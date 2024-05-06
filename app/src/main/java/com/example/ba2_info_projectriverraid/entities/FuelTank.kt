package com.example.ba2_info_projectriverraid.entities

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.example.ba2_info_projectriverraid.R

class FuelTank(
    context: Context,
    shipX: Float,
    shipY: Float,
    shipSize: Pair<Float, Float>,
    health: Float = 1f,
    Bitmap: Bitmap? = BitmapFactory.decodeResource(context.resources, R.drawable.ship)
) : Entities(context,shipX, shipY, shipSize,health, Bitmap)
 {

    }
