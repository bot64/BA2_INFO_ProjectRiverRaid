package com.example.ba2_info_projectriverraid.entities.enemies

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.example.ba2_info_projectriverraid.R
import com.example.ba2_info_projectriverraid.entities.Entities

// Ship.kt
class Ship(
    context: Context,
    shipX: Float,
    shipY: Float,
    shipSize: Pair<Float, Float>,
    health: Float = 1f ,
    Bitmap: Bitmap? = BitmapFactory.decodeResource(context.resources, R.drawable.ship)
) : Entities(context,shipX, shipY, shipSize,health, Bitmap) {

    // Ship-specific properties and methods
    fun create(){}
    fun handle_collision(entity: Entities) {
        // Handle collisions between the ship and other entities
    }

    fun delete() {
        // Remove the ship from the game
    }

    fun pop_entity() {
        // Create a new ship and add it to the game
    }
    fun shot(damage : Float) {
        health -= damage
        if (health <= 0){ delete()
        }
    }
}