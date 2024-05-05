package com.example.ba2_info_projectriverraid.entities

import android.graphics.drawable.Icon

// Missile.kt

class Missile(
    var speed: Double,
    size: Pair<Float, Float>,
    x_pos: Float,
    y_pos: Float,
    image: Icon
) : Entities(x_pos, y_pos, size, image) {
    fun shoot(x_pos: Float, y_pos: Float) {


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