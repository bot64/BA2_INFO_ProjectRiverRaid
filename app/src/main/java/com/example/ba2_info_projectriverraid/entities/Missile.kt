package com.example.ba2_info_projectriverraid.entities

// Missile.kt

class Missile(
    var speed: Double,
    var pos_x: Double,
    var pos_y: Double
) : Entities(pos_x, pos_y, 10.0, Icon("missile.png")) {

    override fun update() {
        // Update the missile's position based on its speed
    }

    override fun outofbound(): Boolean {
        // Check if the missile is outside the game boundaries
        return false
    }

    fun collide(entity: Entities) {
        // Handle collisions between the missile and other entities
    }

    override fun delete() {
        // Remove the missile from the game
    }

}