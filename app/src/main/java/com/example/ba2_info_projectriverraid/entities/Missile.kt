package com.example.ba2_info_projectriverraid.entities

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.Icon
import com.example.ba2_info_projectriverraid.R

// Missile.kt

class Missile(
    context: Context,
    var speed: Float,
    missileX: Float,
    missileY: Float,
    entitiesSize: Pair<Float, Float> ,
    image: Bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.missile),
    override val bitmap: Bitmap
) : Entities(context,missileX, missileY, entitiesSize, health = 1f, image) {
    fun shoot(player: Player) {
        // Set the initial position of the missile to be just above the player
        super.entitiesX = player.entitiesX + (player.entitiesSize.first / 2) - (entitiesSize.first / 2)
        super.entitiesY = player.entitiesY - entitiesSize.second
    }
    fun update() {
        // Update the missile's position based on its speed
    }

    fun outofbound(): Boolean {
        // Check if the missile is outside the game boundaries
        return false
    }

    fun collide(entity: Entities) {
        // Handle collisions between the missile and other entities
    }

    fun delete() {
        // Remove the missile from the game
    }

}
