package com.example.ba2_info_projectriverraid.entities

import android.graphics.drawable.Icon

// Missile.kt

class Missile(
    var speed: Double,
    size: Pair<Float, Float>,
    x_pos: Float,
    y_pos: Float,
    image: Icon
) : Entities(x_pos, y_pos, size, health = 1f, image) {
    fun shoot(player: Player) {
        // Set the initial position of the missile to be just above the player
        x_pos = player.x_pos + (player.size.first / 2) - (size.first / 2)
        y_pos = player.y_pos - size.second
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