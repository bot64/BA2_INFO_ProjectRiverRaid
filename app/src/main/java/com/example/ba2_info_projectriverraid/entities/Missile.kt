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
    size: Pair<Float, Float>,
    missileX: Float,
    missileY: Float,
    image: Bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.missile),
    override val bitmap: Bitmap
) : Entities(entitiesX, entitiesY, entitiesSize, health = 1f, image) {
    fun shoot(player: Player) {
        // Set the initial position of the missile to be just above the player
        missileX = player.x_pos + (player.size.first / 2) - (size.first / 2)
        missileY = player.y_pos - size.second
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
