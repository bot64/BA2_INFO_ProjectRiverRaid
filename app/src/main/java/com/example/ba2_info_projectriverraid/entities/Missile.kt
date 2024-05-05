package com.example.ba2_info_projectriverraid.entities

// Missile.kt

class Missile(
    var speed: Double,

) : Entities(x_pos = 0.0, y_pos = 0.0, size = 10.0) {
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